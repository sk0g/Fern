package com.ymir.fern_app

class MatchingAlgorithm {

    fun Haversine(lat1: Double, long1: Double, lat2: Double, long2: Double): Double {
        // Returns the distance between two co-ordinates,
        // given individual latitudes and longitudes

        val approximateEarthRadius = 6371

        val latDistance  = Math.toRadians(lat2 - lat1)
        val longDistance = Math.toRadians(long2 - long1)

        val l1 = Math.toRadians(lat1)
        val l2 = Math.toRadians(lat2)

        val a: Double = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.sin(longDistance / 2) * Math.sin(longDistance / 2) * Math.cos(l1) * Math.cos(l2)
        val c: Double = 2 * Math.asin(Math.sqrt(a))
        return approximateEarthRadius * c
    }
}