package com.example.receitasapp.data

data class Receita(
    val id: Int,
    val nome: String,
    val tipo: String, // "doce" ou "salgado"
    val ingredientes: List<String>,
    val passos: List<String>
)

object ReceitaData {
    val receitas = listOf(
        Receita(
            1, "Bolo de Chocolate", "doce",
            listOf(
                "3 ovos", "2 xícaras de farinha de trigo", "1 e 1/2 xícara de açúcar",
                "1 xícara de leite", "1/2 xícara de óleo", "1 xícara de chocolate em pó",
                "1 colher (sopa) de fermento"
            ),
            listOf(
                "Preaqueça o forno a 180°C.",
                "Bata ovos, açúcar e óleo até ficar homogêneo.",
                "Adicione leite, farinha e chocolate em pó; misture bem.",
                "Incorpore o fermento delicadamente.",
                "Despeje em forma untada e enfarinhada.",
                "Asse por 35–45 minutos; faça o teste do palito.",
                "Desenforme e deixe esfriar antes de servir."
            )
        ),
        Receita(
            2, "Brigadeiro tradicional", "doce",
            listOf(
                "1 lata de leite condensado", "2 colheres (sopa) de chocolate em pó",
                "1 colher (sopa) de manteiga", "Granulado para finalizar"
            ),
            listOf(
                "Em panela, junte leite condensado, chocolate e manteiga.",
                "Cozinhe em fogo baixo mexendo sempre.",
                "Quando desgrudar do fundo (ponto de brigadeiro), desligue.",
                "Deixe esfriar, unte as mãos, faça bolinhas e passe no granulado."
            )
        ),
        Receita(
            3, "Pudim de leite condensado", "doce",
            listOf(
                "1 lata de leite condensado", "1 lata de leite (medida da lata)",
                "3 ovos", "1 xícara de açúcar (caramelo)"
            ),
            listOf(
                "Faça caramelo derretendo o açúcar na forma de pudim; espalhe.",
                "Bata ovos, leite condensado e leite até homogeneizar.",
                "Despeje na forma caramelizada.",
                "Leve ao forno em banho-maria a 180°C por 50–60 minutos.",
                "Resfrie, desenforme e sirva gelado."
            )
        ),
        Receita(
            4, "Mousse de maracujá", "doce",
            listOf(
                "1 lata de leite condensado", "1 caixinha de creme de leite",
                "1 xícara de suco concentrado de maracujá"
            ),
            listOf(
                "Bata todos os ingredientes no liquidificador.",
                "Leve à geladeira por pelo menos 2 horas.",
                "Sirva com sementes de maracujá por cima (opcional)."
            )
        ),
        Receita(
            5, "Brownie clássico", "doce",
            listOf(
                "200 g de chocolate meio amargo", "150 g de manteiga",
                "3 ovos", "1 xícara de açúcar", "1 xícara de farinha de trigo",
                "1 pitada de sal", "1 colher (chá) de essência de baunilha"
            ),
            listOf(
                "Derreta chocolate com manteiga em banho-maria.",
                "Misture açúcar e ovos; adicione baunilha.",
                "Junte chocolate derretido e incorpore farinha e sal.",
                "Despeje em forma forrada e asse a 180°C por 25–30 minutos.",
                "Resfrie e corte em quadrados."
            )
        ),
        Receita(
            6, "Cookies de chocolate", "doce",
            listOf(
                "2 xícaras de farinha de trigo", "1/2 colher (chá) de bicarbonato",
                "1/2 colher (chá) de fermento", "1 pitada de sal",
                "120 g de manteiga", "3/4 xícara de açúcar", "3/4 xícara de açúcar mascavo",
                "1 ovo", "1 colher (chá) de baunilha", "1 xícara de gotas de chocolate"
            ),
            listOf(
                "Misture ingredientes secos.",
                "Bata manteiga e açúcares; adicione ovo e baunilha.",
                "Junte secos e incorpore as gotas de chocolate.",
                "Faça porções e leve ao forno a 180°C por 10–12 minutos.",
                "Resfrie em grade antes de servir."
            )
        ),
        Receita(
            7, "Quindim", "doce",
            listOf(
                "10 gemas", "200 g de coco ralado", "1 e 1/2 xícara de açúcar",
                "2 colheres (sopa) de manteiga derretida"
            ),
            listOf(
                "Misture gemas peneiradas, açúcar, coco e manteiga.",
                "Despeje em forminhas untadas com açúcar.",
                "Asse em banho-maria a 180°C por 40–50 minutos.",
                "Resfrie e desenforme."
            )
        ),
        Receita(
            8, "Torta de limão", "doce",
            listOf(
                "200 g de biscoito maisena", "100 g de manteiga", "1 lata de leite condensado",
                "1 caixinha de creme de leite", "1/2 xícara de suco de limão",
                "Raspas de limão", "Merengue (opcional)"
            ),
            listOf(
                "Triture biscoitos e misture com manteiga; forre a forma.",
                "Bata leite condensado, creme de leite e suco de limão.",
                "Despeje sobre a base; leve para gelar 2–3 horas.",
                "Finalize com raspas de limão (e merengue se desejar)."
            )
        ),
        Receita(
            9, "Arroz doce cremoso", "doce",
            listOf(
                "1 xícara de arroz", "1 litro de leite", "1/2 xícara de açúcar",
                "1 pau de canela", "Casca de limão", "1 pitada de sal"
            ),
            listOf(
                "Cozinhe o arroz com água até quase secar.",
                "Adicione leite, açúcar, canela e casca de limão.",
                "Cozinhe mexendo até ficar cremoso.",
                "Retire canela e casca; sirva morno com canela em pó."
            )
        ),
        Receita(
            10, "Panqueca doce com banana", "doce",
            listOf(
                "1 xícara de farinha", "1 colher (sopa) de açúcar", "1 ovo",
                "1 xícara de leite", "1 colher (sopa) de manteiga derretida",
                "Banana fatiada", "Mel ou açúcar e canela"
            ),
            listOf(
                "Misture farinha, açúcar, ovo, leite e manteiga.",
                "Cozinhe porções em frigideira antiaderente.",
                "Sirva com banana, mel ou açúcar e canela."
            )
        ),

        Receita(
            11, "Lasanha à bolonhesa", "salgado",
            listOf(
                "Massa para lasanha", "500 g de carne moída", "1 cebola",
                "2 dentes de alho", "400 g de molho de tomate", "300 g de queijo muçarela",
                "200 g de presunto", "Sal, pimenta e azeite"
            ),
            listOf(
                "Refogue cebola e alho no azeite; adicione carne e tempere.",
                "Junte molho de tomate e cozinhe por 10 minutos.",
                "Monte em camadas: molho, massa, presunto, muçarela.",
                "Finalize com queijo; cubra com papel alumínio.",
                "Asse a 180°C por 30–40 minutos; gratine nos últimos minutos."
            )
        ),
        Receita(
            12, "Estrogonofe de frango", "salgado",
            listOf(
                "500 g de peito de frango em cubos", "1 cebola", "2 dentes de alho",
                "200 g de champignon", "2 colheres (sopa) de ketchup",
                "1 colher (sopa) de mostarda", "1 caixinha de creme de leite",
                "Azeite, sal e pimenta"
            ),
            listOf(
                "Refogue cebola e alho; doure o frango e tempere.",
                "Adicione ketchup, mostarda e champignon.",
                "Junte o creme de leite e aqueça sem ferver.",
                "Sirva com arroz branco e batata palha."
            )
        ),
        Receita(
            13, "Feijoada simples", "salgado",
            listOf(
                "500 g de feijão preto", "200 g de bacon", "200 g de linguiça calabresa",
                "1 cebola", "2 dentes de alho", "Folha de louro", "Sal e pimenta"
            ),
            listOf(
                "Cozinhe o feijão com louro até ficar macio.",
                "Refogue bacon, linguiça, cebola e alho.",
                "Misture ao feijão e cozinhe para apurar.",
                "Ajuste o sal e sirva com arroz e farofa."
            )
        ),
        Receita(
            14, "Moqueca capixaba", "salgado",
            listOf(
                "600 g de peixe em postas (robalo/badejo)", "2 tomates", "1 cebola",
                "1 pimentão", "Coentro", "Azeite de oliva", "Colorau", "Sal"
            ),
            listOf(
                "Tempere o peixe com sal.",
                "Em panela, faça camadas de cebola, tomate, pimentão e peixe.",
                "Tempere com colorau e regue com azeite.",
                "Cozinhe tampado até o peixe ficar macio.",
                "Finalize com coentro e sirva."
            )
        ),
        Receita(
            15, "Arroz carreteiro", "salgado",
            listOf(
                "2 xícaras de arroz", "300 g de carne seca dessalgada e desfiada",
                "1 cebola", "2 dentes de alho", "Pimentão (opcional)", "Cheiro-verde",
                "Óleo, sal e pimenta"
            ),
            listOf(
                "Refogue cebola e alho; junte carne seca e pimentão.",
                "Adicione arroz e água; cozinhe até secar.",
                "Finalize com cheiro-verde e ajuste o sal."
            )
        ),
        Receita(
            16, "Coxinha de frango", "salgado",
            listOf(
                "2 xícaras de caldo de frango", "2 xícaras de farinha de trigo",
                "2 colheres (sopa) de manteiga", "Frango desfiado temperado",
                "Farinha de rosca", "Ovos", "Óleo para fritar"
            ),
            listOf(
                "Ferva caldo com manteiga; adicione farinha e mexa até soltar.",
                "Deixe amornar e sove a massa.",
                "Recheie com frango, modele e empane em ovo e farinha de rosca.",
                "Frite em óleo quente até dourar."
            )
        ),
        Receita(
            17, "Escondidinho de carne seca", "salgado",
            listOf(
                "500 g de carne seca dessalgada e desfiada", "1 kg de mandioca cozida",
                "1 caixinha de creme de leite", "Cebola, alho", "Queijo muçarela",
                "Manteiga, sal, pimenta"
            ),
            listOf(
                "Faça purê com mandioca, manteiga e creme de leite.",
                "Refogue carne seca com cebola e alho.",
                "Monte camadas de purê, carne seca e queijo.",
                "Gratine a 200°C por 15–20 minutos."
            )
        ),
        Receita(
            18, "Frango à parmegiana", "salgado",
            listOf(
                "4 filés de frango", "Farinha de trigo", "Ovos", "Farinha de rosca",
                "Molho de tomate", "Queijo muçarela", "Sal, pimenta, óleo"
            ),
            listOf(
                "Tempere os filés; empane em farinha, ovo e farinha de rosca.",
                "Frite ou asse até dourar.",
                "Cubra com molho e queijo; gratine até derreter."
            )
        ),
        Receita(
            19, "Quiche de alho-poró", "salgado",
            listOf(
                "2 xícaras de farinha de trigo", "120 g de manteiga", "1 ovo", "Sal",
                "2 talos de alho-poró", "3 ovos", "200 ml de creme de leite",
                "100 g de queijo", "Pimenta"
            ),
            listOf(
                "Faça a massa: farinha, manteiga, ovo e sal; leve para gelar.",
                "Abra na forma e pré-asse 10 minutos a 180°C.",
                "Refogue alho-poró; misture com ovos, creme e queijo.",
                "Despeje sobre a massa e asse por 25–30 minutos."
            )
        ),
        Receita(
            20, "Tapioca recheada de queijo e tomate", "salgado",
            listOf(
                "Goma de tapioca hidratada", "Queijo coalho ou muçarela",
                "Tomate em cubos", "Orégano", "Sal"
            ),
            listOf(
                "Aqueça frigideira e espalhe a goma até unir.",
                "Adicione queijo, tomate e orégano.",
                "Dobre e aqueça até o queijo derreter; sirva."
            )
        )
    )

    fun getByTipo(tipo: String) = receitas.filter { it.tipo == tipo }
    fun getById(id: Int) = receitas.find { it.id == id } ?: receitas.first()
}
