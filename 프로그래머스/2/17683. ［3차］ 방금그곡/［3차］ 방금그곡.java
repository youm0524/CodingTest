import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = Integer.MIN_VALUE;
        String M = convert(m);
        for(String music : musicinfos){
            String[] musicinfo = music.split(",");
            String[] start = musicinfo[0].split(":");
            String[] end = musicinfo[1].split(":");
            String title = musicinfo[2];
            String song = convert(musicinfo[3]);
            
            int hour = (Integer.parseInt(end[0])-Integer.parseInt(start[0]))*60;
            int min = 0;
            int startTime = Integer.parseInt(start[0]) * 60 
                + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 
                + Integer.parseInt(end[1]);
            int time = endTime - startTime;
            if(check(song, M, time)){
                //System.out.println("in");
                if(max<time){
                    max = time;
                    answer = title;
                }
            }
            
        }
        return answer;
    }
    public String convert(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }
    public boolean check(String song, String m, int time) {
        StringBuilder played = new StringBuilder();

        for (int i = 0; i < time; i++) {
            played.append(song.charAt(i % song.length()));
        }

        return played.toString().contains(m);
    }
}