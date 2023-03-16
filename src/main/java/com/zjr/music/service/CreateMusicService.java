package com.zjr.music.service;

import org.jfugue.Player;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @create: 2023-03-16 14:48
 * @Description:
 */

@Service
@Component
public class CreateMusicService {

    public void Music(){
        Player player = new Player();
        player.play("C D E F G A B C6W");
    }
}
