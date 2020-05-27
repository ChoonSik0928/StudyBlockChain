package study.choonsik.block_chain.concept

import java.security.MessageDigest

/**
 * @param blockSize : 이 필드를 제외한 나머지 데이터들의 크기를 바이트 단위로 표현
 * @param blockHeader : 해당 블록의 메타 데이터를 담고 있는 객체
 * @param transactionCount : 거래 수를 저장하는 필드
 * @param transactions : 거래 정보를 담고있는 Collection
 */
data class Block(
    val blockSize: Int,
    val blockHeader: BlockHeader,
    val transactionCount: Int,
    val transactions: Array<Any>
) {
    fun getBlockHash(): String {
        val messageDigest = MessageDigest.getInstance("SHA-256")

        var blockHash : ByteArray = messageDigest.digest(blockHeader.toString().toByteArray())
        blockHash = messageDigest.digest(blockHash)

        return String(blockHash,0, blockHash.size)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Block

        if (blockSize != other.blockSize) return false
        if (blockHeader != other.blockHeader) return false
        if (transactionCount != other.transactionCount) return false
        if (!transactions.contentEquals(other.transactions)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = blockSize
        result = 31 * result + blockHeader.hashCode()
        result = 31 * result + transactionCount
        result = 31 * result + transactions.contentHashCode()
        return result
    }
}