import java.util.*

data class Vehicle(val plate: String, val vehicleType: VehicleType, val checkin: Calendar = Calendar.getInstance(), val discount: String? = null){
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }
    val parkedTime = ((Calendar.getInstance().timeInMillis - checkin.timeInMillis).toDouble() / 60_000).toInt()

    override fun hashCode(): Int {
        return this.plate.hashCode()
    }
}