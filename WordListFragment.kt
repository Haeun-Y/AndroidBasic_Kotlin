package com.example.fragmentex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragmentex.databinding.FragmentLetterListBinding
import com.example.fragmentex.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {

    private var _binding: FragmentWordListBinding? = null
    private lateinit var textView: TextView

    //null 안전을 위해 _binding? 형태로 액세스 해야함
    private val binding get() = _binding!!
    //null값이 아님을 확실하게 알 수 있는 경우에 !! 사용
    //binding은 ? 연산자없이 액세스 가능
    //커스텀 게터 사용


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //레이아웃 확장 & 다음 루트뷰를 반환
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
        //val view = binding.root
        //return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textView = binding.txtWordList

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}