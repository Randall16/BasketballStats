/**
 * This player object is an aggregate. It will hold ALL of the data and be composed of Kotlin
 * collections of other previously defined classes.
 */
package dev.randallgreene.basketballstats.data.models


data class Player(val info: PlayerInfo,
                  val seasonsPerGame: List<SeasonPerGame>,
                  val postSeasonsPerGame: List<SeasonPerGame> )