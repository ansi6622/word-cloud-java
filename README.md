# Word Cloud

Idea by [lmoehn](https://github.com/lmoehn)

You work for a tech conference company.  Somebody transcribes all the noteworthy quotes from all the speakers,
and enters them into a system.  This system outputs a JSON file that looks like this:

```
{
  "Ila Huels": [
    "OPTIMIZE WEB-ENABLED SUPPLY-CHAINS",
    "brand sexy channels",
    "ENVISIONEER ROBUST E-COMMERCE",
    "TRANSFORM WIRELESS ARCHITECTURES",
    "BENCHMARK CROSS-PLATFORM PARTNERSHIPS"
  ],
  "Cristopher Feest": [
    "BENCHMARK CROSS-PLATFORM PARTNERSHIPS",
    "brand sexy channels",
    "BENCHMARK 24/7 PARADIGMS"
  ]
}
```

Your mission, should you choose to accept it, is to turn the data from this file
into a Map<String, WordStats>, that can be used by a word cloud. The WordStats
class has a integer "getCount" method and a "getPeople" method that is a List<String>.

You can use the below Ruby array as a guide of what the output might look like from the
above input. The hashes will be substituted for the WordStats object.

```
{
  "optimize" => { "count" => 1, "people" => ["Ila Huels"] },
  "web-enabled" => { "count" => 1, "people" => ["Ila Huels"] },
  "supply-chains" => { "count" => 1, "people" => ["Ila Huels"] },
  "brand" => { "count" => 2, "people" => ["Ila Huels", "Cristopher Feest"] },
  "sexy" => { "count" => 2, "people" => ["Ila Huels", "Cristopher Feest"] },
  "channels" => { "count" => 2, "people" => ["Ila Huels", "Cristopher Feest"] },
  "envisioneer" => { "count" => 1, "people" => ["Ila Huels"] },
  "robust" => { "count" => 1, "people" => ["Ila Huels"] },
  "e-commerce" => { "count" => 1, "people" => ["Ila Huels"] },
  "transform" => { "count" => 1, "people" => ["Ila Huels"] },
  "wireless" => { "count" => 1, "people" => ["Ila Huels"] },
  "architectures" => { "count" => 1, "people" => ["Ila Huels"] },
  "benchmark" => { "count" => 3, "people" => ["Ila Huels", "Cristopher Feest"] },
  "cross-platform" => { "count" => 2, "people" => ["Ila Huels", "Cristopher Feest"] },
  "partnerships" => { "count" => 2, "people" => ["Ila Huels", "Cristopher Feest"] },
  "24/7" => { "count" => 1, "people" => ["Cristopher Feest"] },
  "paradigms" => { "count" => 1, "people" => ["Cristopher Feest"] }
}
```

The words appear in a mix of uppercase and lowercase letters, but the resulting word-cloud should be all lowercase,
and counts and speakers should be case-insensitive.

# Extra

Write a file in your bin directory that processes all the words in the `data/quotes.json` file.

# Setup

* Install a [Java 8 development environment](https://github.com/gSchool/setting-up-java8-environment/blob/master/README.md)
* Fork
* Clone
* Generate the IntelliJ project files using `gradle idea`.
* Turn on TravisCI for the fork by
  visiting https://travis-ci.org/profile/<github user name>, clicking the "Sync now" button
  and scrolling down to find the repository to build.
* Create a new branch for your work using `git checkout -b v1`
* Implement specs and code. To run the tests, use `gradle test` or run them 
from within IntelliJ.
* Push using `git push -u origin v1`

## Further Practice

This warmup can be completed multiple times to increase your comfort level with the material.
To work on this from scratch, you can:

1. Add an upstream remote that points to the original repo `git remote add upstream git@github.com:gSchool/data-structures-java.git`
1. Fetch the latest from the upstream remote using `git fetch upstream`
1. Create a new branch from the master branch of the upstream remote `git checkout -b v2 upstream/master`
1. Implement specs and code
1. Push using `git push -u origin v2`

Each time you do the exercise, create a new branch. For example the 3rd time you do the exercise the branch
name will be v3 instead of v2.
