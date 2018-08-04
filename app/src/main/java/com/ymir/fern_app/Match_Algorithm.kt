package com.ymir.fern_app

class MatchingAlgorithm {

    fun getMatchRating(p1: PersonObject, p2: PersonObject): Double {
        // Returns a Double match score, between 0-100
        var interestMatchFactor = 1.0

        val smallerLength = minOf(p1.interests.size, p2.interests.size)
        var commonInterests = 0
        for (interest in p1.interests) {
            if (interest in p2.interests) {
                commonInterests += 1
            }
        }
        interestMatchFactor = (smallerLength.toDouble() / commonInterests * 100)

        val totalDistance:Double = Haversine(p1.latitude, p1.longitude,
                                             p2.latitude, p2.longitude)
        val distanceMatchFactor = Math.pow(2.0, totalDistance * -0.05)

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

data class PersonObject(val interests: ArrayList<String>, val latitude: Double, val longitude: Double)
