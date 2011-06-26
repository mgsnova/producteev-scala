package org.producteev.api

import java.net.URLEncoder
import scala.collection.mutable.HashMap
import scala.collection.mutable.MutableList

import org.producteev.misc.MD5

class RequestParameters(apiKey: String, apiSecret: String) {
  val map = new HashMap[String, String]
  map += "api_key" -> apiKey
  var complexList = new MutableList[String]
  
  def add(key: String, value: String) {
    if (key.contains("[]"))
      complexList += (key + "=" + value)
    else
      map += key -> value
  }

  def signature: String = {
    MD5.sum(signatureRaw)
  }

  def signatureRaw: String = {
    map.toList.sortBy({_._1}).foldLeft("")((sum, pair) => sum + pair._1 + pair._2) + apiSecret
  }

  def urlParameter: String = {
    val keys = map.toList.sortBy({_._1}).map(pair => pair._1 + "=" + URLEncoder.encode(pair._2, "UTF-8")).reduceLeft(_ + "&" + _)
    val complexKeys = if (complexList.isEmpty) "" else ("&" + complexList.reduceLeft(_ + "&" + _))
    keys + complexKeys + "&api_sig=" + signature
  }
}
