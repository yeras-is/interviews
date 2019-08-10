package kotlinExmpl

fun main() {
    var asd = Person("yerassyl", "maikhanov",12,"dev", listOf("Cool","Smart","Proud of him self"))
    println(asd.getFullName())
    println(asd.getRole())
    asd.setRole("asf")
    println(asd.getRole())
}
