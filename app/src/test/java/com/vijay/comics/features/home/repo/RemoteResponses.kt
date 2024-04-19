package com.vijay.comics.features.home.repo

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.vijay.comics.features.home.model.ComicsResponse

fun getListResponse() : ComicsResponse? {
    val raw = "{\n" +
            "  \"code\": 200,\n" +
            "  \"status\": \"Ok\",\n" +
            "  \"copyright\": \"© 2024 MARVEL\",\n" +
            "  \"attributionText\": \"Data provided by Marvel. © 2024 MARVEL\",\n" +
            "  \"attributionHTML\": \"<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2024 MARVEL</a>\",\n" +
            "  \"etag\": \"327bfb10f6dc88135b973b0dcd7feb91cb4c7925\",\n" +
            "  \"data\": {\n" +
            "    \"offset\": 0,\n" +
            "    \"limit\": 3,\n" +
            "    \"total\": 59890,\n" +
            "    \"count\": 3,\n" +
            "    \"results\": [\n" +
            "      {\n" +
            "        \"id\": 82967,\n" +
            "        \"digitalId\": 0,\n" +
            "        \"title\": \"Marvel Previews (2017)\",\n" +
            "        \"issueNumber\": 0,\n" +
            "        \"variantDescription\": \"\",\n" +
            "        \"description\": \"\",\n" +
            "        \"modified\": \"2019-11-07T08:46:15-0500\",\n" +
            "        \"isbn\": \"\",\n" +
            "        \"upc\": \"75960608839302811\",\n" +
            "        \"diamondCode\": \"\",\n" +
            "        \"ean\": \"\",\n" +
            "        \"issn\": \"\",\n" +
            "        \"format\": \"\",\n" +
            "        \"pageCount\": 112,\n" +
            "        \"textObjects\": [],\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82967\",\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"type\": \"detail\",\n" +
            "            \"url\": \"http://marvel.com/comics/issue/82967/marvel_previews_2017?utm_campaign=apiRef&utm_source=d333a166cf86f6a2e6ea93c103cd192c\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"series\": {\n" +
            "          \"resourceURI\": \"http://gateway.marvel.com/v1/public/series/23665\",\n" +
            "          \"name\": \"Marvel Previews (2017 - Present)\"\n" +
            "        },\n" +
            "        \"variants\": [\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82965\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82970\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82969\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/74697\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/72736\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/75668\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/65364\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/65158\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/65028\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/75662\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/74320\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/73776\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"collections\": [],\n" +
            "        \"collectedIssues\": [],\n" +
            "        \"dates\": [\n" +
            "          {\n" +
            "            \"type\": \"onsaleDate\",\n" +
            "            \"date\": \"2099-10-30T00:00:00-0500\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"focDate\",\n" +
            "            \"date\": \"2019-10-07T00:00:00-0400\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"prices\": [\n" +
            "          {\n" +
            "            \"type\": \"printPrice\",\n" +
            "            \"price\": 0\n" +
            "          }\n" +
            "        ],\n" +
            "        \"thumbnail\": {\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available\",\n" +
            "          \"extension\": \"jpg\"\n" +
            "        },\n" +
            "        \"images\": [],\n" +
            "        \"creators\": {\n" +
            "          \"available\": 1,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82967/creators\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"resourceURI\": \"http://gateway.marvel.com/v1/public/creators/10021\",\n" +
            "              \"name\": \"Jim Nausedas\",\n" +
            "              \"role\": \"editor\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"returned\": 1\n" +
            "        },\n" +
            "        \"characters\": {\n" +
            "          \"available\": 0,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82967/characters\",\n" +
            "          \"items\": [],\n" +
            "          \"returned\": 0\n" +
            "        },\n" +
            "        \"stories\": {\n" +
            "          \"available\": 2,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82967/stories\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"resourceURI\": \"http://gateway.marvel.com/v1/public/stories/183698\",\n" +
            "              \"name\": \"cover from Marvel Previews (2017)\",\n" +
            "              \"type\": \"cover\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"resourceURI\": \"http://gateway.marvel.com/v1/public/stories/183699\",\n" +
            "              \"name\": \"story from Marvel Previews (2017)\",\n" +
            "              \"type\": \"interiorStory\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"returned\": 2\n" +
            "        },\n" +
            "        \"events\": {\n" +
            "          \"available\": 0,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82967/events\",\n" +
            "          \"items\": [],\n" +
            "          \"returned\": 0\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 82965,\n" +
            "        \"digitalId\": 0,\n" +
            "        \"title\": \"Marvel Previews (2017)\",\n" +
            "        \"issueNumber\": 0,\n" +
            "        \"variantDescription\": \"\",\n" +
            "        \"description\": \"\",\n" +
            "        \"modified\": \"2019-08-21T17:11:27-0400\",\n" +
            "        \"isbn\": \"\",\n" +
            "        \"upc\": \"75960608839302611\",\n" +
            "        \"diamondCode\": \"JUL190068\",\n" +
            "        \"ean\": \"\",\n" +
            "        \"issn\": \"\",\n" +
            "        \"format\": \"\",\n" +
            "        \"pageCount\": 152,\n" +
            "        \"textObjects\": [],\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82965\",\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"type\": \"detail\",\n" +
            "            \"url\": \"http://marvel.com/comics/issue/82965/marvel_previews_2017?utm_campaign=apiRef&utm_source=d333a166cf86f6a2e6ea93c103cd192c\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"series\": {\n" +
            "          \"resourceURI\": \"http://gateway.marvel.com/v1/public/series/23665\",\n" +
            "          \"name\": \"Marvel Previews (2017 - Present)\"\n" +
            "        },\n" +
            "        \"variants\": [\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82967\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82970\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82969\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/74697\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/72736\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/75668\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/65364\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/65158\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/65028\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/75662\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/74320\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/73776\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"collections\": [],\n" +
            "        \"collectedIssues\": [],\n" +
            "        \"dates\": [\n" +
            "          {\n" +
            "            \"type\": \"onsaleDate\",\n" +
            "            \"date\": \"2099-08-28T00:00:00-0500\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"focDate\",\n" +
            "            \"date\": \"2019-08-05T00:00:00-0400\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"prices\": [\n" +
            "          {\n" +
            "            \"type\": \"printPrice\",\n" +
            "            \"price\": 0\n" +
            "          }\n" +
            "        ],\n" +
            "        \"thumbnail\": {\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available\",\n" +
            "          \"extension\": \"jpg\"\n" +
            "        },\n" +
            "        \"images\": [],\n" +
            "        \"creators\": {\n" +
            "          \"available\": 0,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82965/creators\",\n" +
            "          \"items\": [],\n" +
            "          \"returned\": 0\n" +
            "        },\n" +
            "        \"characters\": {\n" +
            "          \"available\": 0,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82965/characters\",\n" +
            "          \"items\": [],\n" +
            "          \"returned\": 0\n" +
            "        },\n" +
            "        \"stories\": {\n" +
            "          \"available\": 0,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82965/stories\",\n" +
            "          \"items\": [],\n" +
            "          \"returned\": 0\n" +
            "        },\n" +
            "        \"events\": {\n" +
            "          \"available\": 0,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82965/events\",\n" +
            "          \"items\": [],\n" +
            "          \"returned\": 0\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 82970,\n" +
            "        \"digitalId\": 52952,\n" +
            "        \"title\": \"Marvel Previews (2017)\",\n" +
            "        \"issueNumber\": 0,\n" +
            "        \"variantDescription\": \"\",\n" +
            "        \"description\": \"\",\n" +
            "        \"modified\": \"2020-02-07T09:35:32-0500\",\n" +
            "        \"isbn\": \"\",\n" +
            "        \"upc\": \"75960608839303111\",\n" +
            "        \"diamondCode\": \"\",\n" +
            "        \"ean\": \"\",\n" +
            "        \"issn\": \"\",\n" +
            "        \"format\": \"\",\n" +
            "        \"pageCount\": 112,\n" +
            "        \"textObjects\": [],\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82970\",\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"type\": \"detail\",\n" +
            "            \"url\": \"http://marvel.com/comics/issue/82970/marvel_previews_2017?utm_campaign=apiRef&utm_source=d333a166cf86f6a2e6ea93c103cd192c\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"purchase\",\n" +
            "            \"url\": \"http://comicstore.marvel.com/Marvel-Previews-0/digital-comic/52952?utm_campaign=apiRef&utm_source=d333a166cf86f6a2e6ea93c103cd192c\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"reader\",\n" +
            "            \"url\": \"http://marvel.com/digitalcomics/view.htm?iid=52952&utm_campaign=apiRef&utm_source=d333a166cf86f6a2e6ea93c103cd192c\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"inAppLink\",\n" +
            "            \"url\": \"https://applink.marvel.com/issue/52952?utm_campaign=apiRef&utm_source=d333a166cf86f6a2e6ea93c103cd192c\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"series\": {\n" +
            "          \"resourceURI\": \"http://gateway.marvel.com/v1/public/series/23665\",\n" +
            "          \"name\": \"Marvel Previews (2017 - Present)\"\n" +
            "        },\n" +
            "        \"variants\": [\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82967\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82965\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/82969\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/74697\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/72736\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/75668\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/65364\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/65158\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/65028\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/75662\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/74320\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/73776\",\n" +
            "            \"name\": \"Marvel Previews (2017)\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"collections\": [],\n" +
            "        \"collectedIssues\": [],\n" +
            "        \"dates\": [\n" +
            "          {\n" +
            "            \"type\": \"onsaleDate\",\n" +
            "            \"date\": \"2099-01-29T00:00:00-0500\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"focDate\",\n" +
            "            \"date\": \"2020-01-06T00:00:00-0500\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"unlimitedDate\",\n" +
            "            \"date\": \"2020-01-29T00:00:00-0500\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"digitalPurchaseDate\",\n" +
            "            \"date\": \"2020-01-29T00:00:00-0500\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"prices\": [\n" +
            "          {\n" +
            "            \"type\": \"printPrice\",\n" +
            "            \"price\": 0\n" +
            "          },\n" +
            "          {\n" +
            "            \"type\": \"digitalPurchasePrice\",\n" +
            "            \"price\": 0\n" +
            "          }\n" +
            "        ],\n" +
            "        \"thumbnail\": {\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada\",\n" +
            "          \"extension\": \"jpg\"\n" +
            "        },\n" +
            "        \"images\": [\n" +
            "          {\n" +
            "            \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada\",\n" +
            "            \"extension\": \"jpg\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"creators\": {\n" +
            "          \"available\": 1,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82970/creators\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"resourceURI\": \"http://gateway.marvel.com/v1/public/creators/10021\",\n" +
            "              \"name\": \"Jim Nausedas\",\n" +
            "              \"role\": \"editor\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"returned\": 1\n" +
            "        },\n" +
            "        \"characters\": {\n" +
            "          \"available\": 0,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82970/characters\",\n" +
            "          \"items\": [],\n" +
            "          \"returned\": 0\n" +
            "        },\n" +
            "        \"stories\": {\n" +
            "          \"available\": 1,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82970/stories\",\n" +
            "          \"items\": [\n" +
            "            {\n" +
            "              \"resourceURI\": \"http://gateway.marvel.com/v1/public/stories/183704\",\n" +
            "              \"name\": \"cover from Marvel Previews (2017)\",\n" +
            "              \"type\": \"cover\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"returned\": 1\n" +
            "        },\n" +
            "        \"events\": {\n" +
            "          \"available\": 0,\n" +
            "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/82970/events\",\n" +
            "          \"items\": [],\n" +
            "          \"returned\": 0\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}"

    val moshi = Moshi.Builder().build()
    val jsonAdapter: JsonAdapter<ComicsResponse> = moshi.adapter(ComicsResponse::class.java)

    return jsonAdapter.fromJson(raw)
}
