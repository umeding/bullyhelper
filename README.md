bully
=====

Bully helper

## How To

inside "run":

```bash
$ java -cp ../target/bully-1.0.jar com.uwemeding.bully.Bully
-------- @Scotthudson95
Too many people in the Gym this time of day! #worse

> 
```

hit enter to indicate "no bully",
enter "y" and then enter to indicate bully

## Incremental runs
There is a `lineno.txt` file, it defines the last that was processed.
So if you want to start at line 10000, just put that in the file and
the helper tool will forward to line 10000 and show the next tweet.

## Outputs
All processed tweets are stored in `cookedTweets.txt`

## General
To quit press Ctrl-D (EOF) 


