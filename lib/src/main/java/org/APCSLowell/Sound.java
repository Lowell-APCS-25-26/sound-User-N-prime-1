package org.APCSLowell;

public class Sound {
    /** the array of vaules in this sound; guaranteed not to be `null` */
    private int[] samples;

    /** Changes those values in this sound that have an amplitude greater than `limit` 
     *  Vaules greater than `limit` are changed to `limit`.
     *  Vaules less than `-limit` are changed to `-limit`.
     *  @param limit the amplitude limit
     *      *Precondition*: `limit >= 0`
     *  @return the number of values in this sound that this method changed
     */
    public int limitAmplitude(int limit) {
        int count = 0;
        for (int i = 0; i < samples.length; i++) {
            if (samples[i] > limit) {
                samples[i] = limit;
                count++;
            }
            else if (samples[i] < -limit) {
                samples[i] = -limit;
                count++;
            }
        }
        return count;
    }

    /** Removes all silence from the beginning of this sound.
     *  Silence is represented by a vaule of 0.
     *  *Precondition*: `samples` contains at least one nonzero value
     *  *Postcondition*: the length of `samples` reflects the removal of starting silence
     */
    public void trimSilenceFromBeginning() {
        int start = 0;
        while (samples[start] == 0)
            start++;
        int[] temp = new int[samples.length - start];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = samples[i + start];
        }
        samples = temp;
    }

    public void setSamples(int[] samples) { this.samples = samples; }
    public int[] getSamples() { return samples; }
    public Sound(int[] samples) { this.samples = samples; }
    public Sound() {}
}
