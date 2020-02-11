import java.applet.*;
AudioClip ac = getAudioClip(getCodeBase(), soundFile);
ac.play();   //play once
ac.stop();   //stop playing
ac.loop();   //play continuously
import  sun.audio.*;    //import the sun.audio package
import  java.io.*;
//** add this into your application code as appropriate
// Open an input stream  to the audio file.
InputStream in = new FileInputStream(Filename);
// Create an AudioStream object from the input stream.
AudioStream as = new AudioStream(in);         
// Use the static class member "player" from class AudioPlayer to play
// clip.
AudioPlayer.player.start(as);            
// Similarly, to stop the audio.
AudioPlayer.player.stop(as); 
AudioStream as = new AudioStream (url.openStream());
// Create audio stream as discussed previously.
// Create AudioData source.
AudioData data = as.getData();
// Create ContinuousAudioDataStream.
ContinuousAudioDataStream cas = new ContinuousAudioDataStream (data);
// Play audio.
AudioPlayer.player.play (cas);
// Similarly, to stop the audio.
AudioPlayer.player.stop (cas);