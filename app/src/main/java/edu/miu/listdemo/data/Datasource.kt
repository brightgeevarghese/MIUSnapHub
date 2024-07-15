package edu.miu.listdemo.data

import edu.miu.listdemo.R
import edu.miu.listdemo.model.Quote

/***
 * [Datasource] generates a list of [Quote]
 */
class Datasource {
    fun loadQuotes(): List<Quote> {
        return listOf(
            Quote(
                R.string.miu_campus,
                R.drawable.miu_campus
            ),
            Quote(
                R.string.compro_professionals,
                R.drawable.compro_professionals
            ),
            Quote(
                R.string.compro_admission_team,
                R.drawable.compro_admission_team
            ),
            Quote(
                R.string.faculty_student,
                R.drawable.faculty_student
            ),
            Quote(
                R.string.sustainable_living_center,
                R.drawable.sustainable_living_center
            )
        )
    }
}