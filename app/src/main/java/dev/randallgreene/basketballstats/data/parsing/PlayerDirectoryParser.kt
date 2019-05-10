/**
 * This class is for parsing basketball-reference's player directory page for example -
 * https://www.basketball-reference.com/players/a/
 *
 * Note that that page only displays players whose name begin with 'a' so this parsing
 * will need to be called for all letters in the alphabet.
 */
package dev.randallgreene.basketballstats.data.parsing

import dev.randallgreene.basketballstats.data.database.PlayerEntry
import dev.randallgreene.basketballstats.data.models.SeasonPerGame
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

internal object PlayerDirectoryParser {

    internal fun parsePlayerDirectory(doc: Document): List<PlayerEntry> {

        // create query string to locate table in html doc
        val query = HtmlParser.convertToQuery( HtmlTags.PLAYER_PER_GAME_TABLE )

        // select that table from the html doc
        // using "tbody" because table has additional unneeded info in the "tfoot" section
        val table = doc.select(query).select("tbody")

        return parsePlayerDirectoryTable(table)
    }

    private fun parsePlayerDirectoryTable(table: Elements): List<PlayerEntry> {

        // create collection to the seasons to
        val playerEntriesList = mutableListOf<PlayerEntry>()

        // iterate through all rows in the table
        for(row in table.select("tr")) {

            // pick up here
        }

        return playerEntriesList
    }

}