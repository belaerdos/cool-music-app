package com.erdos.coolmusicapp.models;

import lombok.*;

@AllArgsConstructor
@Data
@Getter
@Setter
public class CoolMusicDTO {
    private String title;
    private String artist;
    private String link;
}
