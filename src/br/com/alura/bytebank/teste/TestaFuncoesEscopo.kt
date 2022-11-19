package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.Endereco

fun testaFuncoesEscopo() {
    //  val endereco =  Endereco(logradouro = "Rua X", numero = 19)
//  val enderecoEmMaiusculo =   "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//
//    println(enderecoEmMaiusculo)

    val numeros = mutableListOf<String>("um", "dois", "tres")
    numeros.also { println(numeros) }
        .add("Quatro")
    println(numeros)

    val enderecoEmMaiusculo = Endereco(logradouro = "Rua do Chafariz", numero = 19)
        .run {
            "$logradouro, $numero".toUpperCase()
        }.let(::println)


    val enderecoComComplemento = listOf(
        Endereco(complemento = "Casa"),
        Endereco(),
        Endereco(complemento = "apartamento")
    ).filter { endereco -> endereco.complemento.isNotEmpty() }
        .let(::println)
}
fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12
    println("taxa mensa $taxaMensal")

    val contaPoupanca = ContaPoupanca(Cliente(nome = "Alexandre", cpf = "123.123.123-12", senha = 1234), 1234)
    contaPoupanca
        .run {
            deposita(1000.0)
            saldo * taxaMensal
        }.let { rendimentoMensal ->
            println(rendimentoMensal)
        }

    val rendimentoAnual = run {
        var saldo = contaPoupanca.saldo
        repeat(12) {
            saldo += saldo * taxaMensal

        }
        saldo
    }
    println(rendimentoAnual)
}


//
//fun testaRecebeString(valor:String){
//
//}
//fun testaRecebeInt(valor:Int){
//
//}
//        //Higher Oder Function
//fun teste (teste:Int, bloco: () -> Unit){
//
//}