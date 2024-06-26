package com.bangkit.lungxcan.ui.disease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bangkit.lungxcan.R
import com.bangkit.lungxcan.data.request.DiseaseRequest
import com.bangkit.lungxcan.databinding.FragmentDiseaseBinding

class DiseaseFragment : Fragment() {

    private lateinit var _binding: FragmentDiseaseBinding
    private val list = ArrayList<DiseaseRequest>()

    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiseaseBinding.inflate(inflater, container, false)

        val layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.rvHistory.layoutManager = layoutManager

        binding.appBar.topAppBar.title = getString(R.string.title_disease)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.addAll(getListDisease())

        val diseaseAdapter = DiseaseAdapter(list)
        diseaseAdapter.submitList(list)
        binding.rvHistory.adapter = diseaseAdapter
    }

    private fun getListDisease(): ArrayList<DiseaseRequest> {
        val dataDiseaseNames = resources.getStringArray(R.array.disease_names)
        val dataDiseasePictures = resources.getStringArray(R.array.disease_pictures)
        val dataDiseaseAvailability = resources.getStringArray(R.array.disease_availability)
        val dataDiseaseLinks = resources.getStringArray(R.array.disease_links)
        val dataDiseaseDefinitions = resources.getStringArray(R.array.disease_definitions)
        val dataDiseaseSymptoms = resources.getStringArray(R.array.disease_symptoms)
        val dataDiseaseTreatments = resources.getStringArray(R.array.disease_treatments)
        val dataDiseasePreventions = resources.getStringArray(R.array.disease_preventions)
        val dataDiseaseIcons = resources.getStringArray(R.array.disease_icons)

        val diseaseList = ArrayList<DiseaseRequest>()

        for (i in dataDiseaseNames.indices) {
            val disease = DiseaseRequest(
                disease = dataDiseaseNames[i],
                image = dataDiseasePictures[i],
                availability = dataDiseaseAvailability[i],
                linkRead = dataDiseaseLinks[i],
                definition = dataDiseaseDefinitions[i],
                symptom = dataDiseaseSymptoms[i],
                treatment = dataDiseaseTreatments[i],
                preventive = dataDiseasePreventions[i],
                diseaseIcon = dataDiseaseIcons[i]
            )
            diseaseList.add(disease)
        }

        return diseaseList
    }


//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}