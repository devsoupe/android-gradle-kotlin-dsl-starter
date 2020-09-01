package util

import java.text.SimpleDateFormat
import java.util.*

fun getDateStringByFormatter(formatter: String): String {
  val date = Date()
  val formatter = SimpleDateFormat(formatter)

  return formatter.format(date)
}
