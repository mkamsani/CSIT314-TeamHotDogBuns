package com.hotdog.ctbs.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.hotdog.ctbs.entity.Movie;
import com.hotdog.ctbs.entity.Screening;
import com.hotdog.ctbs.repository.MovieRepository;
import com.hotdog.ctbs.repository.ScreeningRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.hotdog.ctbs.service.MovieService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class MovieImpl implements MovieService{

    private final MovieRepository movieRepository;

    private final ScreeningRepository screeningRepository;

    //this is the enum for content rating (follow the movie "constraints"
    private enum ContentRating {
        g, pg, pg13, nc16, m18, r21
    }

    public MovieImpl(MovieRepository movieRepository, ScreeningRepository screeningRepository)
    {
        this.movieRepository = movieRepository;
        this.screeningRepository = screeningRepository;
    }

    // CustomerMovieReadController
    //  - getAllActiveMoviesDetails() - returns all active movies.
    //  - getActiveMovieByTitle(String title) - returns active movie by title.

    // return a list of active movies objects
    @Override
    public List<Movie> getAllActiveMoviesDetails()
    {
        return movieRepository.findAll().stream()
                .filter(Movie::isActive)
                .toList();
    }

    // get active movie by its title
    @Override
    public Movie getActiveMovieByTitle(String title)
    {
        if (!getAllActiveMoviesTitle().contains(title))
            throw new IllegalArgumentException("The movie doesnt exist.");

        return movieRepository.findMovieByTitle(title);
    }

    // return a list of movie title with true active status (used in getActiveMovieByTitle)
    @Override
    public List<String> getAllActiveMoviesTitle()
    {
        return movieRepository.findAll().stream()
                .filter(Movie::isActive)
                .map(Movie::getTitle)
                .toList();
    }

    ///////////////// end of CustomerMovieReadController //////////////////////

    // MovieCreateController
    //  - createMovie(String title, String genre, String description, LocalDate releaseDate,
    //                String imageUrl, String landscapeImageUrl, boolean isActive,
    //                String contentRating)   - creates a new movie.

    // create a new movie
    @Override
    public void createMovie (String title, String genre, String description,
                             LocalDate releaseDate, String imageUrl, String landscapeImageUrl,
                             String contentRating)
    {
        // the new movie Title must not be the same as any existing title in database (1st check)
        // the content rating must be in lowercase form (2nd check)
        // the content rating must be one of the valid content rating (3trd check)
        for (String existingMovieTitle : getAllMovieTitles())
            if (existingMovieTitle.equalsIgnoreCase(title)){

                // return the movie title message that already exists
                throw new IllegalArgumentException( title + "already exists. Cannot create new movie." +
                        " Please enter a new movie title.");
            }


        if (!contentRating.equals(contentRating.toLowerCase())) {
            throw new IllegalArgumentException("The content rating given must be in lowercase form.");}

        if(!getValidContentRating().contains(contentRating.toLowerCase()))
            throw new IllegalArgumentException("The content rating given is invalid.");

        movieRepository.save(
                Movie.builder()
                        .id(UUID.randomUUID())
                        .title(title)
                        .isActive(true) // just added, from Yao Hui
                        .genre(genre.toLowerCase())
                        .description(description)
                        .releaseDate(releaseDate)
                        .imageUrl(imageUrl)
                        .landscapeImageUrl(landscapeImageUrl)
                        .contentRating(contentRating)
                        .build()
        );
    }

    ///////////////// end of MovieCreateController //////////////////////

    // ManagerMovieReadController
    //  - getAllMoviesDetails() - returns all movies.
    //  - getMovieByTitle(String title) - returns movie by title.

    // return a list of all movies details
    public List<Movie> getAllMoviesDetails() {
        return movieRepository.findAll();
    }

    // return the movie object by input its title
    @Override
    public Movie getMovieByTitle(final String title)
    {
        return movieRepository.findMovieByTitle(title);
    }

    ///////////////// end of ManagerMovieReadController //////////////////////


    // MovieUpdateController
    //  - updateMovie(String targetTitle, String newTitle, String newGenre, String newDescription,
    //                 LocalDate newReleaseDate, String newImageUrl, String newLandscapeImageUrl,
    //                 String newContentRating) - updates a movie.

    // update all attribute of movie except isActive (will be used in Suspend method)
    @Override
    public void updateMovie(String targetTitle, String newTitle, String newGenre, String newDescription,
                            LocalDate newReleaseDate, String newImageUrl, String newLandscapeImageUrl,
                            String newContentRating) {
        boolean movieFound = false;

        // make sure new movie title is not same as other existing movie titles
        for (String existingMovieTitle : getAllMovieTitles())
            if (existingMovieTitle.equalsIgnoreCase(newTitle)){

                throw new IllegalArgumentException("The new movie title" + newTitle + "already exists.");
            }


        // update everything if found the existing movie title
        for (Movie exsitingMovie : movieRepository.findAll()) {
            if (exsitingMovie.getTitle().equals(targetTitle)) {
                exsitingMovie.setTitle(newTitle);
                exsitingMovie.setGenre(newGenre.toLowerCase());
                exsitingMovie.setDescription(newDescription);
                exsitingMovie.setReleaseDate(newReleaseDate);
                exsitingMovie.setImageUrl(newImageUrl);
                exsitingMovie.setLandscapeImageUrl(newLandscapeImageUrl);
                exsitingMovie.setContentRating(newContentRating);
                movieRepository.save(exsitingMovie);
                movieFound = true;
                break;
            }

        }
        // if the movie that would to be updated is not found, throw an exception
        if (!movieFound) {
            throw new IllegalArgumentException("The movie title " + targetTitle +  "you would like to update does not exist.");
        }

    }


    ///////////////// end of MovieUpdateController //////////////////////

    // MovieSuspendController
    //  - suspendMovie(String title) - suspends movie by title.

    // suspend the movie by input its title
    @Override
    public void suspendMovie (String targetTitle) {
        boolean movieFound = false;
        // update the movie's active status if found the existing movie title
        for (Movie exsitingMovie : movieRepository.findAll()) {
            if (exsitingMovie.getTitle().equalsIgnoreCase(targetTitle)){
                exsitingMovie.setActive(false);
                movieRepository.save(exsitingMovie);
                movieFound = true;
                break;
            }

        }
        // if the movie title that would to be updated is not found, throw an exception
        if (!movieFound){
            // throw an exception including targetTitle name if the movie title is not found
        throw new IllegalArgumentException("The movie " + targetTitle + "you would like to suspend does not exist.");
        }
    }

    @Transactional
    @Override
    public void deleteMovieByTitle(String title)
    {
        // check if the movie title exists
        boolean movieFound = false;
        for (Movie existingMovie : movieRepository.findAll()) {
            if (existingMovie.getTitle().equalsIgnoreCase(title)){
                movieFound = true;
                break;
            }
        }

        if (!movieFound){
            throw new IllegalArgumentException("The movie "+ title + " you would like to delete does not exist.");
        }

        // check if the movie has screenings
        /*for (Movie existingMovie : movieRepository.findAll()) {

            if (existingMovie.getTitle().equals(title)){

                if(existingMovie.getScreenings().size() > 0)
                    throw new IllegalArgumentException("The movie cannot be deleted because it has screenings.");
                else{
                    System.out.println("Delete method called");
                    movieRepository.delete(existingMovie);
                    System.out.println("Movie " + title + " has been deleted.");
                    break;
                }

            }

        }*/

        // make sure the movie has no future screening
        for (Screening existingScreening : screeningRepository.findAll()) {
            if (existingScreening.getMovie().getTitle().equalsIgnoreCase(title)){
                LocalDate showDate = existingScreening.getShowDate();
                if (showDate.isAfter(LocalDate.now()))
                    throw new IllegalArgumentException("The movie " + title + " you would like to delete has the screening in the future.");
                if (showDate.isAfter(LocalDate.now().minusDays(30)))
                    throw new IllegalArgumentException("You cant delete a movie" + title + "that has the screening in the past less than 30 days.");
            }
        }
        movieRepository.delete(movieRepository.findMovieByTitle(title));
    }

    ///////////////// end of MovieDeleteController //////////////////////


    // return a list of titles of all movies
    @Override
    public List<String> getAllMovieTitles()
    {
        return movieRepository.findAll().stream()
                                    .map(Movie::getTitle)
                                    .toList();
    }

    // return a list of genres of all movies
    @Override
    public List<String> getAllMovieGenres()
    {
        return movieRepository.findAll().stream()
                                    .map(Movie::getGenre)
                                    .toList();
    }

    // return a list of descriptions of all movies
    @Override
    public List<String> getAllMovieDescriptions()
    {
        return movieRepository.findAll().stream()
                                    .map(Movie::getDescription)
                                    .toList();
    }

    // return a list of release dates of all movies
    @Override
    public List<LocalDate> getAllMovieReleaseDates()
    {
        return movieRepository.findAll().stream()
                                    .map(Movie::getReleaseDate)
                                    .toList();
    }

    //return a list of image URL of all movies
    @Override
    public List<String> getAllMovieImagesURL()
    {
        return movieRepository.findAll().stream()
                                    .map(Movie::getImageUrl)
                                    .toList();
    }

    // return a list of content rating for all existing movies in the database (might not be used)
    @Override
    public List<String> getAllContentRating()
    {
        return movieRepository.findAll().stream()
                .map(Movie::getContentRating)
                .toList();
    }

    // return a list of valid content ratings (followed the check constraint)
    @Override
    public List<String> getValidContentRating()
    {
        return Stream.of(ContentRating.values())
                .map(Enum::name)
                .toList();
    }


    // return a list of movie title and image url with true active status
    @Override
    public List<String> getAllActiveMoviesTitleAndImageUrl()
    {
        return movieRepository.findAll().stream()
                .filter(Movie::isActive)
                .map(movie -> movie.getTitle() + " " + movie.getImageUrl())
                .toList();
    }

    // return the movie by input its id
    @Override
    public Movie getMovieById(final UUID id)
    {
        return movieRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("The movie id does not exist.")
        );
    }

    // return the movie's id by input its title
    @Override
    public UUID getMovieIdByTitle(final String title)
    {
        // throw illegal argument if movie is not found
        for (Movie movie : movieRepository.findAll())
            if (movie.getTitle().equals(title))
                return movie.getId();

        throw new IllegalArgumentException("The movie title does not exist.");
    }


    // all the methods to update movie with different attributes
    // update the movie's title by input its title and new title
    @Override
    public void updateMovieByTitle(String targetTitle, String newTitle)
    {
        boolean movieFound = false;

        // the new movie Title must not be the same as any existing title in database
        for (String existingMovieTitle : getAllMovieTitles())
            if (existingMovieTitle.equalsIgnoreCase(newTitle))
                throw new IllegalArgumentException("The movie title already exists.");

        // update the movie title if found the existing movie title
        for (Movie exsitingMovie : movieRepository.findAll()) {
            if (exsitingMovie.getTitle().equals(targetTitle)){
                exsitingMovie.setTitle(newTitle);
                movieRepository.save(exsitingMovie);
                movieFound = true;
                break;
            }

        }
        // if the movie title that would to be updated is not found, throw an exception
        if (!movieFound){
            throw new IllegalArgumentException("The movie title you would " +
                    "like to update does not exist.");
        }
    }

    // update the movie's genre by input its title and new genre
    @Override
    public void updateMovieByGenre(String targetTitle, String newGenre)
    {
        boolean movieFound = false;
        // update the movie genre if found the existing movie title
        for (Movie exsitingMovie : movieRepository.findAll()) {
            if (exsitingMovie.getTitle().equals(targetTitle)){
                exsitingMovie.setGenre(newGenre.toLowerCase());
                movieRepository.save(exsitingMovie);
                movieFound = true;
                break;
            }

        }
        // if the movie title that would to be updated is not found, throw an exception
        if (!movieFound){
            throw new IllegalArgumentException("The movie title you would " +
                    "like to update does not exist.");
        }
    }


    // update the movie's description by input its title and new description
    @Override
    public void updateMovieByDescription(String targetTitle, String newDescription)
    {
        boolean movieFound = false;
        // update the movie description if found the existing movie title
        for (Movie exsitingMovie : movieRepository.findAll()) {
            if (exsitingMovie.getTitle().equals(targetTitle)){
                exsitingMovie.setDescription(newDescription);
                movieRepository.save(exsitingMovie);
                movieFound = true;
                break;
            }

        }
        // if the movie title that would to be updated is not found, throw an exception
        if (!movieFound){
            throw new IllegalArgumentException("The movie title you would " +
                    "like to update does not exist.");
        }
    }

    // update the movie's release date by input its title and new release date
    @Override
    public void updateMovieByReleaseDate(String targetTitle, LocalDate newReleaseDate)
    {
        boolean movieFound = false;
        // update the movie release date if found the existing movie title
        for (Movie exsitingMovie : movieRepository.findAll()) {
            if (exsitingMovie.getTitle().equals(targetTitle)){
                exsitingMovie.setReleaseDate(newReleaseDate);
                movieRepository.save(exsitingMovie);
                movieFound = true;
                break;
            }

        }
        // if the movie title that would to be updated is not found, throw an exception
        if (!movieFound){
            throw new IllegalArgumentException("The movie title you would " +
                    "like to update does not exist.");
        }
    }

    // update the movie's image url by input its title and new image url
    @Override
    public void updateMovieByImageUrl(String targetTitle, String newImageUrl)
    {
        boolean movieFound = false;
        // update the movie's image URL if found the existing movie title
        for (Movie exsitingMovie : movieRepository.findAll()) {
            if (exsitingMovie.getTitle().equals(targetTitle)){
                exsitingMovie.setImageUrl(newImageUrl);
                movieRepository.save(exsitingMovie);
                movieFound = true;
                break;
            }

        }
        // if the movie title that would to be updated is not found, throw an exception
        if (!movieFound){
            throw new IllegalArgumentException("The movie title you would " +
                    "like to update does not exist.");
        }
    }

    // update movie by landscape image url
    @Override
    public void updateMovieByLandscapeImageUrl(String targetTitle, String newLandscapeImageUrl)
    {
        boolean movieFound = false;
        // update the movie's landscape image URL if found the existing movie title
        for (Movie exsitingMovie : movieRepository.findAll()) {
            if (exsitingMovie.getTitle().equals(targetTitle)){
                exsitingMovie.setLandscapeImageUrl(newLandscapeImageUrl);
                movieRepository.save(exsitingMovie);
                movieFound = true;
                break;
            }

        }
        // if the movie title that would to be updated is not found, throw an exception
        if (!movieFound){
            throw new IllegalArgumentException("The movie title you would " +
                    "like to update does not exist.");
        }
    }

    // update the movie's active status by input its title and new active status
    @Override
    public void updateMovieByIsActive(String targetTitle, boolean newIsActive)
    {
        boolean movieFound = false;
        // update the movie status if found the existing movie title
        for (Movie exsitingMovie : movieRepository.findAll()) {
            if (exsitingMovie.getTitle().equals(targetTitle)){
                exsitingMovie.setActive(newIsActive);
                movieRepository.save(exsitingMovie);
                movieFound = true;
                break;
            }

        }
        // if the movie title that would to be updated is not found, throw an exception
        if (!movieFound){
            throw new IllegalArgumentException("The movie title you would " +
                    "like to update does not exist.");
        }
    }

    // update the movie's content rating by input its title and new content rating
    @Override
    public void updateMovieByContentRating(String targetTitle, String newContentRating)
    {
        boolean movieFound = false;

        // make sure the new content rating follow the format and is valid
        if (!newContentRating.equals(newContentRating.toLowerCase())) {
            throw new IllegalArgumentException("The content rating given must be in lowercase form.");}
        if(!getValidContentRating().contains(newContentRating.toLowerCase()))
            throw new IllegalArgumentException("The content rating given is invalid.");

        // update the content rating if found the existing movie title
        for (Movie exsitingMovie : movieRepository.findAll()) {
            if (exsitingMovie.getTitle().equals(targetTitle)){
                exsitingMovie.setContentRating(newContentRating);
                movieRepository.save(exsitingMovie);
                movieFound = true;
                break;
            }

        }
        // if the movie title that would to be updated is not found, throw an exception
        if (!movieFound){
            throw new IllegalArgumentException("The movie title you would " +
                    "like to update does not exist.");
        }
    }

    public String MovieResponse(Movie movie) throws JsonProcessingException
    {
        ObjectMapper om = new ObjectMapper();
        JsonNode jn = om.readTree(om.writeValueAsString(movie));
        ((ObjectNode) jn).remove("id");
        return jn.toString();
    }

    @Override
    public String MoviesResponse(List<Movie> movies) throws JsonProcessingException
    {
        StringBuilder sb = new StringBuilder("[");
        for (Movie movie : movies)
            sb.append(MovieResponse(movie))
                    .append(",");

        return sb.deleteCharAt(sb.length() - 1)
                .append("]")
                .toString();
    }

    @Override
    public Movie MovieRequest(String json) throws JsonProcessingException
    {
        return movieRepository.findMovieByTitle(
                new ObjectMapper().readValue(json, Movie.class).getTitle()
        );
    }

    @Override
    public List<Movie> MoviesRequest(String json) throws JsonProcessingException
    {
        List<Movie> movies =
                new ObjectMapper().readValue(json, new TypeReference<>() {
                });
        return movies.stream()
                .map(movie -> movieRepository.findMovieByTitle(movie.getTitle()))
                .toList();
    }

    /////////////////////// consider suspend method ///////////////////////

    ///////////////////////////////////////////////////////////////////////////////

   /* @Override
    public void updateMovieByAllAttributes(String targetTitle, String newTitle, String newGenre, String newDescription,
                                           LocalDate newReleaseDate, String newImageUrl, String newLandscapeImageUrl, boolean newIsActive, String newContentRating) {
        boolean movieFound = false;

        // make sure new movie title is not same as other existing movie titles
        for (String existingMovieTitle : getAllMovieTitles())
            if (existingMovieTitle.equalsIgnoreCase(newTitle))
                throw new IllegalArgumentException("The new movie title already exists.");

        // update everything if found the existing movie title
        for (Movie exsitingMovie : movieRepository.findAll()) {
            if (exsitingMovie.getTitle().equals(targetTitle)) {
                exsitingMovie.setTitle(newTitle);
                exsitingMovie.setGenre(newGenre.toLowerCase());
                exsitingMovie.setDescription(newDescription);
                exsitingMovie.setReleaseDate(newReleaseDate);
                exsitingMovie.setImageUrl(newImageUrl);
                exsitingMovie.setLandscapeImageUrl(newLandscapeImageUrl);
                exsitingMovie.setActive(newIsActive);
                exsitingMovie.setContentRating(newContentRating);
                movieRepository.save(exsitingMovie);
                movieFound = true;
                break;
            }

        }
        // if the movie that would to be updated is not found, throw an exception
        if (!movieFound) {
            throw new IllegalArgumentException("The movie you would " +
                    "like to update does not exist.");
        }

    }*/





}
