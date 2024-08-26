package com.github.mbrito.havagas

import Formulario
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.mbrito.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        setupListeners()
    }

    private fun setupListeners() {
        amb.telefoneCelularCb.setOnCheckedChangeListener { _, isChecked ->
            amb.telefoneCelularLt.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        amb.formacaoSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val formacao = (view as TextView).text.toString()
                amb.fundamentalMedioLt.visibility = if (formacao in arrayOf("Fundamental", "Medio")) View.VISIBLE else View.GONE
                amb.graduacaoEspecializacaoLt.visibility = if (formacao in arrayOf("Graduacao", "Especializacao", "Mestrado", "Doutorado")) View.VISIBLE else View.GONE
                amb.mestradoDoutoradoLt.visibility = if (formacao in arrayOf("Mestrado", "Doutorado")) View.VISIBLE else View.GONE
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Nada Selecionado", Toast.LENGTH_SHORT).show()
            }
        }

        amb.btnSalvar.setOnClickListener {
            val formulario = getFormData()
            showFormData(formulario)
        }
    }

    private fun getFormData(): Formulario {
        val nome = amb.nomeEt.text.toString()
        val email = amb.emailEt.text.toString()
        val desejaAtualizacoes = amb.atualizacoesCb.isChecked
        val tipoTelefone = when (amb.tipoTelefoneRg.checkedRadioButtonId) {
            R.id.tipoTelefoneComercialRb -> "Comercial"
            R.id.tipoTelefoneResidencialRb -> "Residencial"
            else -> ""
        }
        val telefone = amb.telefoneEt.text.toString()
        val telefoneCelular = if (amb.telefoneCelularCb.isChecked) amb.telefoneCelularEt.text.toString() else ""
        val sexo = when (amb.sexoRg.checkedRadioButtonId) {
            R.id.masculinoRb -> "Masculino"
            R.id.femininoRb -> "Feminino"
            else -> ""
        }
        val dataNascimento = amb.dataNascimentoEt.text.toString()
        val formacao = amb.formacaoSp.selectedItem.toString()
        val anoFormatura = amb.anoFormaturaEt.text.toString()
        val anoConclusao = amb.anoConclusaoEt.text.toString()
        val instituicao = amb.instituicaoEt.text.toString()
        val tituloMonografia = amb.tituloMonografiaEt.text.toString()
        val orientador = amb.orientadorEt.text.toString()
        val vagasInteresse = amb.vagasInteresseEt.text.toString()

        return Formulario(
            nome, email, desejaAtualizacoes, tipoTelefone, telefone, telefoneCelular, sexo, dataNascimento,
            formacao, anoFormatura, anoConclusao, instituicao, tituloMonografia, orientador, vagasInteresse
        )
    }

    private fun showFormData(formulario: Formulario) {
        Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
    }
}
