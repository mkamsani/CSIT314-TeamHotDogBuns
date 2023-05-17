package com.hotdog.ctbs.repository;

import com.hotdog.ctbs.entity.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Integer> {


    List<CinemaRoom> findCinemaRoomByIsActiveTrue();
}
