/**
 * This class just acts as an easy way to call the necessary parsing methods. It delegates the work to
 * the proper internal parsing class.
 */
package dev.randallgreene.basketballstats.data.parsing

import dev.randallgreene.basketballstats.data.models.SeasonPerGame
import org.jsoup.nodes.Document

object HtmlParser {

    internal fun convertToQuery(tag: String): String = "table[id=$tag]"

    fun parsePlayerSeasonsPerGame(doc: Document): List<SeasonPerGame>
            = PlayerStatsParser.parsePlayerSeasonsPerGame(doc)

}