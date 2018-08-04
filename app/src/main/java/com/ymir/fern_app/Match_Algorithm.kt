package com.ymir.fern_app

class MatchingAlgorithm {

    fun getMatchRating(p1: Person, p2: Person): Double {
        var interestMatchFactor = 1.0
        // Implement interest similarity algorithm

        var totalDistance:Double = Haversine(p1.latitude, p1.longitude,
                                             p2.latitude, p2.longitude)
        var distanceMatchFactor = Math.pow(2.0, totalDistance * -0.05)

        return interestMatchFactor * distanceMatchFactor
    }

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

data class Person(val interests: ArrayList<String>, val latitude: Double, val longitude: Double)
