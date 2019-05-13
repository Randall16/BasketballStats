/**
 * File contains all classes for parsing Basketball-Reference's html
 */
package dev.randallgreene.basketballstats.data.parsing

import dev.randallgreene.basketballstats.data.database.PlayerEntry
import dev.randallgreene.basketballstats.data.models.SeasonPerGame
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

// Public class that exposes necessary parsing methods to rest of the application
object HtmlParser {

    internal fun convertToQuery(tag: String): String = "table[id=$tag]"

    fun parsePlayerSeasonsPerGame(doc: Document): List<SeasonPerGame>
            = PlayerStatsParser.parsePlayerSeasonsPerGame(doc)

    fun parsePlayerDirectory(doc: Document): List<PlayerEntry>
            = PlayerDirectoryParser.parsePlayerDirectory(doc)

}

/**  BELOW ARE METHODS FOR PARSING INDIVIDUAL PAGES OF BASKETBALL-REFERENCE  **/


/**
 * This class is for parsing basketball-reference's player directory page for example -
 * https://www.basketball-reference.com/players/a/
 *
 * Note that that page only displays players whose name begin with 'a' so this parsing
 * will need to be called for all letters in the alphabet.
 */
private object PlayerDirectoryParser {

    fun parsePlayerDirectory(doc: Document): List<PlayerEntry> {

        // create query string to locate table in html doc
        val query = HtmlParser.convertToQuery( HtmlTags.PLAYER_DIRECTORY_TABLE )

        // select that table from the html doc
        // using "tbody" because table has additional unneeded info in the "tfoot" section
        val table = doc.select(query).select("tbody")

        return parsePlayerDirectoryTable(table)
    }

    private fun parsePlayerDirectoryTable(table: Elements): List<PlayerEntry> {

        // create collection to add the entries to
        val playerEntriesList = mutableListOf<PlayerEntry>()

        // iterate through all rows in the player directory table
        for(row in table.select("tr")) {

            // name and link is stored in the header so pull from there
            val name = row.select("th").text().toString()
            val link = row.select("a").attr("href")

            // start and end year are stored in table data so pull from there
            val startYear = row.select("td")[0].text().toInt()
            val endYear = row.select("td")[1].text().toInt()

            // create the player entry
            val playerEntry = PlayerEntry(link, name, startYear, endYear)

            // insert that entry into the list
            playerEntriesList.add(playerEntry)
        }

        return playerEntriesList
    }
}



/**
 * This is for parsing an individual player's stats page for example -
 * https://www.basketball-reference.com/players/n/nashst01.html
 */
private object PlayerStatsParser {

    fun parsePlayerSeasonsPerGame(doc: Document): List<SeasonPerGame> {

        // create query string to locate table in html doc
        val query = HtmlParser.convertToQuery( HtmlTags.PLAYER_PER_GAME_TABLE )

        // select that table from the html doc
        // using "tbody" because table has additional unneeded info in the "tfoot" section
        val table = doc.select(query).select("tbody")

        return parsePerGamesTable(table)
    }

    private fun parsePerGamesTable(table: Elements): List<SeasonPerGame> {

        // create collection to the seasons to
        val seasonsList = mutableListOf<SeasonPerGame>()

        // iterate through all rows in the table
        for(row in table.select("tr")) {

            // year is stored in the header so pull from there
            val year = row.select("th").text().toString()

            // rest of the data is stored in the row's columns
            val column = row.select("td")

            // now extract the desired data one by one
            val age = column[0].text().toInt()
            val team = column[1].text().toString()
            val position = column[3].text().toString()
            val games = column[4].text().toInt()
            val gamesStarted = column[5].text().toInt()
            val minutes = column[6].text().toDouble()
            val fgs = column[7].text().toDouble()
            val fgsAttempted = column[8].text().toDouble()
            val fgPercent = column[9].text().toDouble()
            val threes = column[10].text().toDouble()
            val threesAttempted = column[11].text().toDouble()
            val threePercent = column[12].text().toDouble()
            val twos = column[13].text().toDouble()
            val twosAttempted = column[14].text().toDouble()
            val twoPercent = column[15].text().toDouble()
            val efg = column[16].text().toDouble()
            val fts = column[17].text().toDouble()
            val ftsAttempted = column[18].text().toDouble()
            val ftPercent = column[19].text().toDouble()
            val orb = column[20].text().toDouble()
            val drb = column[21].text().toDouble()
            val trb = column[22].text().toDouble()
            val ast = column[23].text().toDouble()
            val stl = column[24].text().toDouble()
            val blk = column[25].text().toDouble()
            val tov = column[26].text().toDouble()
            val pf = column[27].text().toDouble()
            val pts = column[28].text().toDouble()

            // now create SeasonPerGame object
            val seasonPerGame = SeasonPerGame(year, age, team, position, games, gamesStarted, minutes,
                fgs, fgsAttempted, fgPercent, threes, threesAttempted, threePercent, twos, twosAttempted,
                twoPercent, efg, fts, ftsAttempted, ftPercent, orb, drb, trb, ast, stl, blk, tov, pf, pts)

            // add the individual season that was just created to the list
            seasonsList.add(seasonPerGame)
        }

        return seasonsList
    }
}