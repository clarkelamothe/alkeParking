import kotlin.math.abs
import kotlin.math.ceil

open class Parkable(open val vehicle: Vehicle, open val vehicles: MutableSet<Vehicle>) {
    var earnings: Int = 0
    var totalCheckedOut: Int = 0
    var checkedOutPlates = arrayListOf<String>()

    fun checkOutVehicle(plate: String){

        val carOut = vehicles.filter{ plate == it.plate }
        when(carOut.size){
            1 -> {
                var discount: String = (carOut[0].discount ?: "")
                var fee = calculateFee(carOut[0].vehicleType, carOut[0].parkedTime, discount != "")
                onSuccess(carOut[0], fee)
                vehicles.remove(carOut[0])
                earnings += fee
                totalCheckedOut++
                checkedOutPlates.add(carOut[0].plate)
            }
            else -> onError()
        }
    }


    fun onSuccess(vehicle: Vehicle, calculate: Int) =
        println("Your fee is $$calculate. Come back soon.")


    fun onError() = println("Sorry, the check-out failed")

    fun calculateFee(vehicleType: VehicleType, parkedTime: Int, hasDiscountCard: Boolean): Int {
        val parkedFee = vehicleType.price + abs(ceil((parkedTime - 120).toDouble()/15) * 5)
        parkedFee =  return when(hasDiscountCard){
            true -> ceil((parkedFee * (1 - 0.15))).toInt()
            else -> parkedFee.toInt()
        }
    }
}
