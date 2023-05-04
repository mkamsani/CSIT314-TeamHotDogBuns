package com.hotdog.ctbs.entity;


import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(name = "show_time", nullable = false, length = 9)
    private String showTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinema_room", nullable = false)
    private CinemaRoom cinemaRoom;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "date_of_movie", nullable = false)
    private LocalDate dateOfMovie;

    @SneakyThrows
    @Override
    public String toString()
    {
        return new ObjectMapper().registerModule(new JavaTimeModule())
                .writeValueAsString(this);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Screening that)) return false;
        return id.equals(that.id) && movie.equals(that.movie) && showTime.equals(that.showTime) && cinemaRoom.equals(that.cinemaRoom) && isActive.equals(that.isActive) && dateOfMovie.equals(that.dateOfMovie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, showTime, cinemaRoom, isActive, dateOfMovie);
    }


}