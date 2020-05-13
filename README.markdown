# sdet

A simple sentence commandline appilcation which writes the longest word with length, and the shortest word with lenght of the provided sentence to the standard output.

Where a word is any sequence of letters [a-zA-Z] seperated by any other character. 

## Installation

mvn clean install

## Usage

From the target directory : 

`java -jar "sdet-1.0.0-SNAPSHOT-jar-with-dependencies.jar" "SENTENCE"`

Where SENTENCE for example "The cow jumped over the moon."

`java -jar "sdet-1.0.0-SNAPSHOT-jar-with-dependencies.jar" "The cow jumped over the moon."`

will return the following :

`[main] INFO com.troweprice.sdet.Sentence - The cow jumped over the moon.`

`[main] INFO com.troweprice.sdet.SentenceApp - Longest  : jumped,6`

`[main] INFO com.troweprice.sdet.SentenceApp - Shortest : The,3`


## History

See [CHANGELOG](CHANGELOG.markdown)

## Credits

Scott Redden

## License

[Apache License v2.0](LICENSE)  
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0.html)