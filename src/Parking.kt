data class Parking(override val vehicles: MutableSet<Vehicle>, override val vehicle: Vehicle): Parkable(vehicle, vehicles)   {
    var availableSpot: Int = 20

    fun addVehicle(vehicle: Vehicle): Boolean {
        return when (availableSpot) {
            in 1..availableSpot -> {
                println("Welcome to AlkeParking!")
                vehicles.add(vehicle)
                availableSpot--
                true
            } else -> {
                println("Sorry, the check-in failed")
                false
            }
        }
    }

    fun registryInformation(){
        var registry= Pair(earnings, totalCheckedOut)
        println("${registry.second
        } vehicles have checked out and have earnings of $${registry.first}")
    }

    fun listVehicles(){
        println("List of checked out cars plate: $checkedOutPlates")
    }
}
