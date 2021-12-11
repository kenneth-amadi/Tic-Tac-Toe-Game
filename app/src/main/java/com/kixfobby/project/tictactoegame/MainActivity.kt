package com.kixfobby.project.tictactoegame

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val items: MutableList<String> = mutableListOf("", "", "", "", "", "", "", "", "")
    val mAdapter = BaseGridAdapter(this, items)
    var player = "A"
    var ls: ArrayList<Int> = ArrayList()
    private var isClickable = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.setHasFixedSize(true)

        recyclerView.adapter = mAdapter

        val listener = object : BaseGridAdapter.OnItemClickListener {
            override fun onItemClick(view: View?, obj: String?, position: Int) {
                if (!isClickable) {
                    return
                } else {

                    val row1 = listOf(0, 1, 2)
                    val row2 = listOf(3, 4, 5)
                    val row3 = listOf(6, 7, 8)
                    val col1 = listOf(0, 3, 6)
                    val col2 = listOf(1, 4, 7)
                    val col3 = listOf(2, 5, 8)
                    val dia1 = listOf(0, 4, 8)
                    val dia2 = listOf(2, 4, 6)

                    items[position] = "X"
                    mAdapter.notifyItemChanged(position)

                    if (items[row1[0]] == "X" && items[row1[1]] == "X" && items[row1[2]] == "X") result()
                    else if (items[row2[0]] == "X" && items[row2[1]] == "X" && items[row2[2]] == "X") result()
                    else if (items[row3[0]] == "X" && items[row3[1]] == "X" && items[row3[2]] == "X") result()
                    else if (items[col1[0]] == "X" && items[col1[1]] == "X" && items[col1[2]] == "X") result()
                    else if (items[col2[0]] == "X" && items[col2[1]] == "X" && items[col2[2]] == "X") result()
                    else if (items[col3[0]] == "X" && items[col3[1]] == "X" && items[col3[2]] == "X") result()
                    else if (items[dia1[0]] == "X" && items[dia1[1]] == "X" && items[dia1[2]] == "X") result()
                    else if (items[dia2[0]] == "X" && items[dia2[1]] == "X" && items[dia2[2]] == "X") result()
                    else player = "B"

                    for (a in 0..3) {
                        val r = 0..8
                        ls.add(r.random())
                    }

                    if (player == "B") {
                        Handler(Looper.getMainLooper()).postDelayed(
                            {
                                /// ROW 1b
                                if (items[row1[0]] == "O" && items[row1[1]] == "O" && items[row1[2]] != "X") {
                                    items[row1[2]] = "O"
                                    player = "A"
                                    mAdapter.notifyItemChanged(row1[2])

                                } else if (items[row1[0]] == "O" && items[row1[2]] == "O" && items[row1[1]] != "X") {
                                    items[row1[1]] = "O"
                                    player = "A"
                                    mAdapter.notifyItemChanged(row1[1])

                                } else if (items[row1[1]] == "O" && items[row1[2]] == "O" && items[row1[0]] != "X") {
                                    items[row1[0]] = "O"
                                    player = "A"
                                    mAdapter.notifyItemChanged(row1[0])

                                } else

                                /// ROW 2b
                                    if (items[row2[0]] == "O" && items[row2[1]] == "O" && items[row2[2]] != "X") {
                                        items[row2[2]] = "O"
                                        player = "A"
                                        mAdapter.notifyItemChanged(
                                            row2[2]
                                        )

                                    } else if (items[row2[0]] == "O" && items[row2[2]] == "O" && items[row2[1]] != "X") {
                                        items[row2[1]] = "O"
                                        player = "A"
                                        mAdapter.notifyItemChanged(
                                            row2[1]
                                        )

                                    } else if (items[row2[1]] == "O" && items[row2[2]] == "O" && items[row2[0]] != "X") {
                                        items[row2[0]] = "O"
                                        player = "A"
                                        mAdapter.notifyItemChanged(
                                            row2[0]
                                        )

                                    } else

                                    /// ROW 3b
                                        if (items[row3[0]] == "O" && items[row3[1]] == "O" && items[row3[2]] != "X") {
                                            items[row3[2]] = "O"
                                            player = "A"
                                            mAdapter.notifyItemChanged(
                                                row3[2]
                                            )

                                        } else if (items[row3[0]] == "O" && items[row3[2]] == "O" && items[row3[1]] != "X") {
                                            items[row3[1]] = "O"
                                            player = "A"
                                            mAdapter.notifyItemChanged(
                                                row3[1]
                                            )

                                        } else if (items[row3[1]] == "O" && items[row3[2]] == "O" && items[row3[0]] != "X") {
                                            items[row3[0]] = "O"
                                            player = "A"
                                            mAdapter.notifyItemChanged(
                                                row3[0]
                                            )

                                        } else

                                        /// COL 1b
                                            if (items[col1[0]] == "O" && items[col1[1]] == "O" && items[col1[2]] != "X") {
                                                items[col1[2]] = "O"
                                                player = "A"
                                                mAdapter.notifyItemChanged(
                                                    col1[2]
                                                )

                                            } else if (items[col1[0]] == "O" && items[col1[2]] == "O" && items[col1[1]] != "X") {
                                                items[col1[1]] = "O"
                                                player = "A"
                                                mAdapter.notifyItemChanged(
                                                    col1[1]
                                                )

                                            } else if (items[col1[1]] == "O" && items[col1[2]] == "O" && items[col1[0]] != "X") {
                                                items[col1[0]] = "O"
                                                player = "A"
                                                mAdapter.notifyItemChanged(
                                                    col1[0]
                                                )

                                            } else

                                            /// COL 2b
                                                if (items[col2[0]] == "O" && items[col2[1]] == "O" && items[col2[2]] != "X") {
                                                    items[col2[2]] =
                                                        "O"
                                                    player = "A"
                                                    mAdapter.notifyItemChanged(
                                                        col2[2]
                                                    )

                                                } else if (items[col2[0]] == "O" && items[col2[2]] == "O" && items[col2[1]] != "X") {
                                                    items[col2[1]] =
                                                        "O"
                                                    player = "A"
                                                    mAdapter.notifyItemChanged(
                                                        col2[1]
                                                    )

                                                } else if (items[col2[1]] == "O" && items[col2[2]] == "O" && items[col2[0]] != "X") {
                                                    items[col2[0]] =
                                                        "O"
                                                    player =
                                                        "A"
                                                    mAdapter.notifyItemChanged(
                                                        col2[0]
                                                    )

                                                } else

                                                /// COL 3b
                                                    if (items[col3[0]] == "O" && items[col3[1]] == "O" && items[col3[2]] != "X") {
                                                        items[col3[2]] =
                                                            "O"
                                                        player =
                                                            "A"
                                                        mAdapter.notifyItemChanged(
                                                            col3[2]
                                                        )

                                                    } else if (items[col3[0]] == "O" && items[col3[2]] == "O" && items[col3[1]] != "X") {
                                                        items[col3[1]] =
                                                            "O"
                                                        player =
                                                            "A"
                                                        mAdapter.notifyItemChanged(
                                                            col3[1]
                                                        )

                                                    } else if (items[col3[1]] == "O" && items[col3[2]] == "O" && items[col3[0]] != "X") {
                                                        items[col3[0]] =
                                                            "O"
                                                        player =
                                                            "A"
                                                        mAdapter.notifyItemChanged(
                                                            col3[0]
                                                        )

                                                    } else

                                                    /// DIA 1b
                                                        if (items[dia1[0]] == "O" && items[dia1[1]] == "O" && items[dia1[2]] != "X") {
                                                            items[dia1[2]] =
                                                                "O"
                                                            player =
                                                                "A"
                                                            mAdapter.notifyItemChanged(
                                                                dia1[2]
                                                            )

                                                        } else if (items[dia1[0]] == "O" && items[dia1[2]] == "O" && items[dia1[1]] != "X") {
                                                            items[dia1[1]] =
                                                                "O"
                                                            player =
                                                                "A"
                                                            mAdapter.notifyItemChanged(
                                                                dia1[1]
                                                            )

                                                        } else if (items[dia1[1]] == "O" && items[dia1[2]] == "O" && items[dia1[0]] != "X") {
                                                            items[dia1[0]] =
                                                                "O"
                                                            player =
                                                                "A"
                                                            mAdapter.notifyItemChanged(
                                                                dia1[0]
                                                            )

                                                        } else

                                                        /// DIA 2b
                                                            if (items[dia2[0]] == "O" && items[dia2[1]] == "O" && items[dia2[2]] != "X") {
                                                                items[dia2[2]] =
                                                                    "O"
                                                                player =
                                                                    "A"
                                                                mAdapter.notifyItemChanged(
                                                                    dia2[2]
                                                                )

                                                            } else if (items[dia2[0]] == "O" && items[dia2[2]] == "O" && items[dia2[1]] != "X") {
                                                                items[dia2[1]] =
                                                                    "O"
                                                                player =
                                                                    "A"
                                                                mAdapter.notifyItemChanged(
                                                                    dia2[1]
                                                                )

                                                            } else if (items[dia2[1]] == "O" && items[dia2[2]] == "O" && items[dia2[0]] != "X") {
                                                                items[dia2[0]] =
                                                                    "O"
                                                                player =
                                                                    "A"
                                                                mAdapter.notifyItemChanged(
                                                                    dia2[0]
                                                                )

                                                            } else

                                                            /// ROW 1
                                                                if (items[row1[0]] == "X" && items[row1[1]] == "X" && items[row1[2]] != "O") {
                                                                    items[row1[2]] = "O"
                                                                    player = "A"
                                                                    mAdapter.notifyItemChanged(row1[2])

                                                                } else if (items[row1[0]] == "X" && items[row1[2]] == "X" && items[row1[1]] != "O") {
                                                                    items[row1[1]] = "O"
                                                                    player = "A"
                                                                    mAdapter.notifyItemChanged(row1[1])

                                                                } else if (items[row1[1]] == "X" && items[row1[2]] == "X" && items[row1[0]] != "O") {
                                                                    items[row1[0]] = "O"
                                                                    player = "A"
                                                                    mAdapter.notifyItemChanged(row1[0])

                                                                } else

                                                                /// ROW 2--
                                                                    if (items[row2[0]] == "X" && items[row2[1]] == "X" && items[row2[2]] != "O") {
                                                                        items[row2[2]] = "O"
                                                                        player = "A"
                                                                        mAdapter.notifyItemChanged(
                                                                            row2[2]
                                                                        )

                                                                    } else if (items[row2[0]] == "X" && items[row2[2]] == "X" && items[row2[1]] != "O") {
                                                                        items[row2[1]] = "O"
                                                                        player = "A"
                                                                        mAdapter.notifyItemChanged(
                                                                            row2[1]
                                                                        )

                                                                    } else if (items[row2[1]] == "X" && items[row2[2]] == "X" && items[row2[0]] != "O") {
                                                                        items[row2[0]] = "O"
                                                                        player = "A"
                                                                        mAdapter.notifyItemChanged(
                                                                            row2[0]
                                                                        )

                                                                    } else

                                                                    /// ROW 3
                                                                        if (items[row3[0]] == "X" && items[row3[1]] == "X" && items[row3[2]] != "O") {
                                                                            items[row3[2]] = "O"
                                                                            player = "A"
                                                                            mAdapter.notifyItemChanged(
                                                                                row3[2]
                                                                            )

                                                                        } else if (items[row3[0]] == "X" && items[row3[2]] == "X" && items[row3[1]] != "O") {
                                                                            items[row3[1]] = "O"
                                                                            player = "A"
                                                                            mAdapter.notifyItemChanged(
                                                                                row3[1]
                                                                            )

                                                                        } else if (items[row3[1]] == "X" && items[row3[2]] == "X" && items[row3[0]] != "O") {
                                                                            items[row3[0]] = "O"
                                                                            player = "A"
                                                                            mAdapter.notifyItemChanged(
                                                                                row3[0]
                                                                            )

                                                                        } else

                                                                        /// COL 1
                                                                            if (items[col1[0]] == "X" && items[col1[1]] == "X" && items[col1[2]] != "O") {
                                                                                items[col1[2]] = "O"
                                                                                player = "A"
                                                                                mAdapter.notifyItemChanged(
                                                                                    col1[2]
                                                                                )

                                                                            } else if (items[col1[0]] == "X" && items[col1[2]] == "X" && items[col1[1]] != "O") {
                                                                                items[col1[1]] = "O"
                                                                                player = "A"
                                                                                mAdapter.notifyItemChanged(
                                                                                    col1[1]
                                                                                )

                                                                            } else if (items[col1[1]] == "X" && items[col1[2]] == "X" && items[col1[0]] != "O") {
                                                                                items[col1[0]] = "O"
                                                                                player = "A"
                                                                                mAdapter.notifyItemChanged(
                                                                                    col1[0]
                                                                                )

                                                                            } else

                                                                            /// COL 2
                                                                                if (items[col2[0]] == "X" && items[col2[1]] == "X" && items[col2[2]] != "O") {
                                                                                    items[col2[2]] =
                                                                                        "O"
                                                                                    player = "A"
                                                                                    mAdapter.notifyItemChanged(
                                                                                        col2[2]
                                                                                    )

                                                                                } else if (items[col2[0]] == "X" && items[col2[2]] == "X" && items[col2[1]] != "O") {
                                                                                    items[col2[1]] =
                                                                                        "O"
                                                                                    player = "A"
                                                                                    mAdapter.notifyItemChanged(
                                                                                        col2[1]
                                                                                    )

                                                                                } else if (items[col2[1]] == "X" && items[col2[2]] == "X" && items[col2[0]] != "O") {
                                                                                    items[col2[0]] =
                                                                                        "O"
                                                                                    player =
                                                                                        "A"
                                                                                    mAdapter.notifyItemChanged(
                                                                                        col2[0]
                                                                                    )

                                                                                } else

                                                                                /// COL 3
                                                                                    if (items[col3[0]] == "X" && items[col3[1]] == "X" && items[col3[2]] != "O") {
                                                                                        items[col3[2]] =
                                                                                            "O"
                                                                                        player =
                                                                                            "A"
                                                                                        mAdapter.notifyItemChanged(
                                                                                            col3[2]
                                                                                        )

                                                                                    } else if (items[col3[0]] == "X" && items[col3[2]] == "X" && items[col3[1]] != "O") {
                                                                                        items[col3[1]] =
                                                                                            "O"
                                                                                        player =
                                                                                            "A"
                                                                                        mAdapter.notifyItemChanged(
                                                                                            col3[1]
                                                                                        )

                                                                                    } else if (items[col3[1]] == "X" && items[col3[2]] == "X" && items[col3[0]] != "O") {
                                                                                        items[col3[0]] =
                                                                                            "O"
                                                                                        player =
                                                                                            "A"
                                                                                        mAdapter.notifyItemChanged(
                                                                                            col3[0]
                                                                                        )

                                                                                    } else

                                                                                    /// DIA 1
                                                                                        if (items[dia1[0]] == "X" && items[dia1[1]] == "X" && items[dia1[2]] != "O") {
                                                                                            items[dia1[2]] =
                                                                                                "O"
                                                                                            player =
                                                                                                "A"
                                                                                            mAdapter.notifyItemChanged(
                                                                                                dia1[2]
                                                                                            )

                                                                                        } else if (items[dia1[0]] == "X" && items[dia1[2]] == "X" && items[dia1[1]] != "O") {
                                                                                            items[dia1[1]] =
                                                                                                "O"
                                                                                            player =
                                                                                                "A"
                                                                                            mAdapter.notifyItemChanged(
                                                                                                dia1[1]
                                                                                            )

                                                                                        } else if (items[dia1[1]] == "X" && items[dia1[2]] == "X" && items[dia1[0]] != "O") {
                                                                                            items[dia1[0]] =
                                                                                                "O"
                                                                                            player =
                                                                                                "A"
                                                                                            mAdapter.notifyItemChanged(
                                                                                                dia1[0]
                                                                                            )

                                                                                        } else

                                                                                        /// DIA 2
                                                                                            if (items[dia2[0]] == "X" && items[dia2[1]] == "X" && items[dia2[2]] != "O") {
                                                                                                items[dia2[2]] =
                                                                                                    "O"
                                                                                                player =
                                                                                                    "A"
                                                                                                mAdapter.notifyItemChanged(
                                                                                                    dia2[2]
                                                                                                )

                                                                                            } else if (items[dia2[0]] == "X" && items[dia2[2]] == "X" && items[dia2[1]] != "O") {
                                                                                                items[dia2[1]] =
                                                                                                    "O"
                                                                                                player =
                                                                                                    "A"
                                                                                                mAdapter.notifyItemChanged(
                                                                                                    dia2[1]
                                                                                                )

                                                                                            } else if (items[dia2[1]] == "X" && items[dia2[2]] == "X" && items[dia2[0]] != "O") {
                                                                                                items[dia2[0]] =
                                                                                                    "O"
                                                                                                player =
                                                                                                    "A"
                                                                                                mAdapter.notifyItemChanged(
                                                                                                    dia2[0]
                                                                                                )

                                                                                            } else

                                                                                                for (s in ls) {
                                                                                                    if (items[s] == "") {
                                                                                                        items[s] =
                                                                                                            "O"
                                                                                                        player =
                                                                                                            "A"
                                                                                                        mAdapter.notifyItemChanged(
                                                                                                            s
                                                                                                        )
                                                                                                        break
                                                                                                    }
                                                                                                }


                            }, 500
                        )
                    }
                }
            }
        }
        mAdapter.setOnItemClickListener(listener)
    }

    private fun result() {
        Toast.makeText(this@MainActivity, "YOU WON!", Toast.LENGTH_SHORT).show()
        isClickable = false
        //PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("isClickable", false).apply()
        return
    }
}
