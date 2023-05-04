<!DOCTYPE html>
<html lang="en">

<?php
session_start();
include('header.php');
?>

<nav class="navbar navbar-expand-sm">
<div class="container">
        <a class="navbar-brand" href="index.php">
            <img src="Pics/my_enrolment.png" alt="Avatar Logo" style="width:25px; margin-bottom: 5px"> Online Enrolment System
        </a>
        <ul class="nav nav-pills">
            <li class="nav-item">
                <a class="nav-link" href="educator_Profile.php">My Profile</a>
            </li>
            &emsp;
            &emsp;
            <li class="nav-item">
                <a class="nav-link" href="educator_subjectlist.php">View Subjects</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="educator_teachingsubjects.php">Teaching Subjects</a>
            </li>
            &emsp;
            <form class="d-flex">
                <a class="btn btn-outline-primary" href="logout.php">Log Out</a>
            </form>
        </ul>
    </div>
</nav>

<body>
<div class="container-fluid p-5 bg-primary text-white text-center">
    <h1>Teaching Subjects List</h1>
    <p>Educator ID: <?php echo $_SESSION["userId"] ?></p>
</div>

<div class="container mt-3 center">
    <div class="input-group mb-3" style="width: 40%; margin: auto;">
        <span class="input-group-text" id="searchLbl">Search:</span>
        <input type="text" class="form-control" id="searchBox" onkeyup="tableSearch()" id="searchLbl">
    </div>
    <table id="subjectTable" class="table table-hover" style="margin: auto; width: 75%; table-layout: fixed">
        <thead>
        <tr>
            <th>Subject Code</th>
            <th>Subject Name</th>
            <th>Lecturer</th>
            <th>Educator ID</th>
            <th>Venue</th>
        </tr>
        </thead>
        <tbody>
        <?php 
        // DB Config
        $DB_Username = 'root';
        $DB_Password = '';
        $DB = 'isit307a2';

        $link = new mysqli('localhost', $DB_Username, $DB_Password, $DB) or die("Unable to connect to server.");

        // Display Subjects
        $userId = $_SESSION["userId"];
        $sql = "SELECT * FROM subject WHERE Status = 'Active' AND EducatorId = '$userId'";
        $result = $link->query($sql);

        if ($result->num_rows > 0)
        {
            while ($row = $result->fetch_assoc())
            {
                echo "<tr>";
                echo "<td>";
                echo "<a href=\"educator_studentlist.php?subCode=", $row["SubjectCode"], "\">";
                echo "<div style='text-transform: uppercase'>";
                echo $row["SubjectCode"];
                echo "</div>";
                echo "</a>";
                echo "</td>";
                echo "<td>";
                echo $row["SubjectName"];
                echo "</td>";
                echo "<td>";
                echo $row["Lecturer"];
                echo "</td>";
                echo "<td>";
                echo $row["EducatorId"];
                echo "</td>";
                echo "<td>";
                echo $row["Venue"];
                echo "</td>";
                echo "<td>";
            }
            echo "</table>";
        }

        else
        {
            echo '<label class="mt-1">There are no subjects at the moment. Check back again later.</label>';
        }
        $link->close();
        ?>
        </tbody>
    </table>
    <script>
        function tableSearch()
        {
            // Declare variables
            var input, filter, table, tr, td, i;
            input = document.getElementById("searchBox");
            filter = input.value.toUpperCase();
            table = document.getElementById("subjectTable");
            tr = table.getElementsByTagName("tr"),
                th = table.getElementsByTagName("th");

            // Loop through all table rows, and hide those who don't match the search query
            for (i = 1; i < tr.length; i++)
            {
                tr[i].style.display = "none";
                for (var j = 0; j < th.length; j++)
                {
                    td = tr[i].getElementsByTagName("td")[j];
                    if (td)
                    {
                        if (td.innerHTML.toUpperCase().indexOf(filter.toUpperCase()) > -1)
                        {
                            tr[i].style.display = "";
                            break;
                        }
                    }
                }
            }
        }
    </script>
</div>

</body>
<?php include('footer.php') ?>
</html>