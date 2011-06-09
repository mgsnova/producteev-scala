package org.producteev.api

import scala.collection.mutable.HashMap

import org.producteev.misc.MD5

class RequestParameters(apiKey: String, apiSecret: String) {
  val map = new HashMap[String, String]
  map += "api_key" -> apiKey
  
  def add(key: String, value: String) {
    map += key -> value
  }

  def signature: String = {
    MD5.sum(signatureRaw)
  }

  def signatureRaw: String = {
    map.toList.sortBy({_._1}).foldLeft("")((sum, pair) => sum + pair._1 + pair._2) + apiSecret
  }

  def urlParameter: String = {
    val keys = map.toList.sortBy({_._1}).map(pair => pair._1 + "=" + pair._2).reduceLeft(_ + "&" + _)
    keys + "&api_sig=" + signature
  }
}
