package study.choonsik.block_chain.concept

/**
 * @param version : 소프트웨어 또는 프로토콜 등의 업그레이드를 추적하기 위해 사용되는 버전 정보
 * @param previousBlockHash : 블록체인 상의 이전 블록(부모 블록)의 해시값
 * @param merkleRootHash : 머클트리의 루트에 대한 해시값
 * @param timeStamp : 블록 생성 시간
 * @param difficultyTarget : 난이도 (채굴 과정에서 필요한 작업 증명 (proof of work) 알고리즘의 난이도 목표)
 * @param nonce : 채굴과정의 작업 증명에서 사용되는 카운터
 */
class BlockHeader {
    private var version: Int = 0
    private var previousBlockHash: ByteArray = byteArrayOf()
    private var merkleRootHash: Int = 0
    private var timeStamp: Long = 0L
    private var difficultyTarget: Int = 0
    private var nonce: Int = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BlockHeader

        if (version != other.version) return false
        if (!previousBlockHash.contentEquals(other.previousBlockHash)) return false
        if (merkleRootHash != other.merkleRootHash) return false
        if (timeStamp != other.timeStamp) return false
        if (difficultyTarget != other.difficultyTarget) return false
        if (nonce != other.nonce) return false

        return true
    }

    override fun hashCode(): Int {
        var result = version
        result = 31 * result + previousBlockHash.contentHashCode()
        result = 31 * result + merkleRootHash
        result = 31 * result + timeStamp.hashCode()
        result = 31 * result + difficultyTarget
        result = 31 * result + nonce
        return result
    }

    override fun toString(): String {
        return "BlockHeader(version=$version, previousBlockHash=${previousBlockHash.contentToString()}, merkleRootHash=$merkleRootHash, timeStamp=$timeStamp, difficultyTarget=$difficultyTarget, nonce=$nonce)"
    }

}