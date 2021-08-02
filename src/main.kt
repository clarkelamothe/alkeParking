import java.util.*

fun main(){
    val arrayOfVehicle = arrayListOf(
        Vehicle("AAAA", VehicleType.AUTO, discount = "DISCOUNT_CARD_001"),
        Vehicle("BBBB", VehicleType.MOTO),
        Vehicle("CCCC", VehicleType.MINIBUS),
        Vehicle("DDDD", VehicleType.BUS, discount ="DISCOUNT_CARD_002"),
        Vehicle("EEEE", VehicleType.BUS, discount ="DISCOUNT_CARD_002"),
        Vehicle("FFFF", VehicleType.BUS, discount ="DISCOUNT_CARD_002")
    )
    val setOfVehicle: MutableSet<Vehicle> = mutableSetOf(
        Vehicle("AAAA", VehicleType.AUTO, discount = "DISCOUNT_CARD_001"),
        Vehicle("BBBB", VehicleType.MOTO),
        Vehicle("CCCC", VehicleType.MINIBUS),
        Vehicle("DDDD", VehicleType.BUS, discount ="DISCOUNT_CARD_002"),
        Vehicle("EEEE", VehicleType.BUS, discount ="DISCOUNT_CARD_002"),
        Vehicle("FFFF", VehicleType.BUS, discount ="DISCOUNT_CARD_002")
    )
    val parking = Parking(setOfVehicle, Vehicle("FFFF", VehicleType.MOTO))

    // adds all vehicle in parking
    arrayOfVehicle.forEach { vehicle -> parking.addVehicle(vehicle) }

    // Test check out vehicles
    parking.checkOutVehicle("AAAA")
    parking.checkOutVehicle("BBBB")
    parking.checkOutVehicle("CCCC")
    parking.checkOutVehicle("DDDD")
    parking.checkOutVehicle("EEEE")


//    val car2 = Vehicle("GGGG", VehicleType.AUTO, discount = "DISCOUNT_CARD_003")
//    val isCar2Inserted = parking.addVehicle(car2)


    // List vehicles
    parking.listVehicles()
    // Registry
    parking.registryInformation()

}