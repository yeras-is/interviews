package kotlinExmpl

fun main() {
    var asd = Person("yerassyl", "maikhanov",19,"dev", listOf("Cool","Smart","Proud of him self"))
    println(asd.getFullName())
    println(asd.getRole())
    asd.setRole("asf")
    println(asd.getRole())
}
