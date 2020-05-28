package study.choonsik.block_chain

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import study.choonsik.block_chain.concept.Block
import study.choonsik.block_chain.concept.BlockHeader


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createBlock()
    }

    fun createBlock() {
        // Genesis block
        val transactions: Array<Any> = arrayOf("Hosang sent 1k Bitcoins to Zuckerberg.")
        val genesisBlock = Block(BlockHeader(transactions = transactions), transactions)
        Log.d("Block_TAG", "Block Hash : " + genesisBlock.getBlockHash())

        // Second block
        val secondTransactions: Array<Any> = arrayOf("Zuckerberg sent 500 Bitcoins to Hosang.")
        val secondBlock = Block(
            BlockHeader(genesisBlock.getBlockHash()!!.toByteArray(), secondTransactions),
            secondTransactions
        )
        Log.d("Block_TAG", "Second Block Hash : " + secondBlock.getBlockHash())

        // Third block
        val thirdTransactions: Array<Any> =
            arrayOf("Hosang sent 500 Bitcoins to Moon.")
        val thirdBlock = Block(
            BlockHeader(secondBlock.getBlockHash()!!.toByteArray(), thirdTransactions),
            thirdTransactions
        )
        Log.d("Block_TAG", "Third Block Hash : " + thirdBlock.getBlockHash())
    }
}
