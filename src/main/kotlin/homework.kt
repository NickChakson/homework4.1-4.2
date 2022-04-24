const val VISA_MIR_TAX: Double = 0.0075
const val VISA_MIR_MIN_TAX: Double = 35_00.0
const val MASTERCARD_MAESTRO_TAX: Double = 0.006
const val MASTERCARD_MAESTRO_MIN_TAX: Double = 2000.0
const val MASTERCARD_MAESTRO_MAX_TRANSFER: Double = 75_000_00.0

fun main() {

    print("Сумма предыдущих переводов в этом месяце (в рублях): ")
    val transferBefore: Double = readln().toDouble() * 100
    val card = typeCard()
    println("Укажите сумму перевода: ")
    val transfer = readln().toDouble() * 100

    val taxMastercardMaestro = taxForTransferMastercardMaestro(transferBefore, transfer)
    val taxVkPay = taxForTransferVkPay()
    val taxVisaMir = taxForTransferVisaMir(transfer)

    when (card) {
        "Mastercard", "Maestro" -> {
            println(("При переводе " + transfer / 100 + " руб. комиссия составит " + taxMastercardMaestro / 100) + " руб.")
        }
        "VK Pay" -> {
            println(("При переводе " + transfer / 100 + " руб. комиссия составит " + taxVkPay / 100) + " руб.")
        }

        "Visa", "Mir" -> {
            println(("При переводе " + transfer / 100 + " руб. комиссия составит " + taxVisaMir / 100) + " руб.")
        }
    }


}

fun typeCard(): String {
    println("Укажите платёжную систему")
    println("1. Mastercard")
    println("2. Maestro")
    println("3. Visa")
    println("4. МИР")
    println("5. VK Pay")
    return when (readln()) {
        "1" -> "Mastercard"
        "2" -> "Maestro"
        "3" -> "Visa"
        "4" -> "МИР"
        "5" -> "VK Pay"
        else -> "Ошибка"
    }
}

fun taxForTransferVkPay(): Double {
    return 0.0
}

fun taxForTransferVisaMir(_transfer: Double): Double {
    val tax = _transfer * VISA_MIR_TAX
    return if (tax < VISA_MIR_MIN_TAX) VISA_MIR_MIN_TAX else tax
}

fun taxForTransferMastercardMaestro(
    _transferBefore: Double,
    _transfer: Double
): Double {
    val tax = (_transfer * MASTERCARD_MAESTRO_TAX) + MASTERCARD_MAESTRO_MIN_TAX
    return if (_transferBefore > MASTERCARD_MAESTRO_MAX_TRANSFER) tax else 0.0


}
