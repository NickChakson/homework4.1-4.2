import org.junit.Test

import org.junit.Assert.*

class HomeworkKtTest {

    @Test
    fun taxForTransferVisaMirWithFullFees() {
        val transfer: Double = 10_000_00.00
        val result: Int = taxForTransferVisaMir(_transfer = transfer).toInt()
        assertEquals(7500, result)

    }

    @Test
    fun taxForTransferVisaMirWithMinFees() {
        val transfer: Double = 10000.0
        val result: Int = taxForTransferVisaMir(_transfer = transfer).toInt()
        assertEquals(3500, result)

    }

    @Test
    fun taxForTransferMastercardMaestroWithFees() {
        val transfer: Double = 40_000_00.0
        val transferBefore: Double = 100_000_00.0
        val result = taxForTransferMastercardMaestro(
            _transferBefore = transferBefore,
            _transfer = transfer
        ).toInt()
        assertEquals(26000, result)
    }

    @Test
    fun taxForTransferMastercardMaestroNoFees() {
        val transfer: Double = 40_000_00.0
        val transferBefore: Double = 0.0
        val result = taxForTransferMastercardMaestro(
            _transferBefore = transferBefore,
            _transfer = transfer
        ).toInt()
        assertEquals(0, result)
    }
}