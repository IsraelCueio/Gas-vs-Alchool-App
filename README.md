Nome: Israel Coelho Cunha
Matrícula: 470037

## Introdução

Este aplicativo, tem como intuito auxiliar na escolha entre abastecer com álcool ou com gasolina.</br>
Ao inserir o valor do Litro da Gasolina e o valor do litro do Álcool, o aplicativo calcula o quão mais barato o Álcool está com relação a Gasolina. Se o preço do álcool for menos que 70%(ou 75% a depender do modelo) do preço da gasolina, o abastecimento com álcool é recomendado.</br>
## Desenvolvimento
### Conectando a variável percentual ao Switch
A depender do modelo do carro, é necessário que o álcool seja apenas 75% do preço da gasolina, ao invés de 70%, para que seja recomendado o abastecimento à álcool. 
A variável **percentual** se encarrega de guardar a porcentagem máxima do preço do álcool com relação a gasolina para posteriores cálculos.</br>
Embora já existente, a variável ainda não estava ligada ao **switch** responsável por alternar o valor entre 70% e 75%.</br>
![image](https://github.com/IsraelCueio/Gas-vs-Alchool-App/assets/68167016/55b17ba9-0b98-48d8-9748-12f44212df1d)

A imagem acima, mostra um trecho de código do arquivo **Activity_main.xml**, onde o Switch foi declarado. Utilizamos o método **android:onClick** para chamar a função **onClickSwitch** que será declarada em **MainAcitivity.kt** como mostrado na imagem abaixo. O método citado irá executar a função **onClickSwitch** sempre que houver interação com o **Switch**.</br>

![4b7cb7c9-d4e0-4947-8e2f-d496f9178746](https://github.com/IsraelCueio/Gas-vs-Alchool-App/assets/68167016/8d6f985c-b77b-4082-adfc-08e33ae7f5cd)</br>
Acima podemos ver, a função **onClickSwitch** sendo declarada em **MainActivity.kt**. Dentro da função foi criada a variável **s** do tipo **Switch**, adquirida da View (não foi necessário declarar um id para se referir ao Switch, o App só possui um).
Podemos chamar então o método de Switch, **isSwitched**, que retorna um booleano para checar se houve ou não interação com o Switch e assim alterar o valor de percentual entre 0.75 e 0.7.</br>

### Assegurar a permanência de estado da variável **percentual**
Em diversos casos durante o uso de um aplicativo, a tela precisa ser reconstruída, um exemplo é quando giramos o dispositivo móvel da posição vertical para a horizontal. Quando isto ocorre, o aplicativo precisa reconstruir a tela, perdendo o estado de algumas variáveis. Quando queremos que o estato dessas variáveis persista, precisamos executar algumas passos.</br>
![image](https://github.com/IsraelCueio/Gas-vs-Alchool-App/assets/68167016/ac6f85d8-c8dc-4aca-b14a-08ca3d691a54)</br>

No trecho de código do arquivo **MainAcitivity.kt** mostrado acima, foi utilizada a função **onSaveInstanceState**, onde nós escrevemos a variável que desejamos salvar no **bundle** com um id "percentual", seguida da função **onCreate**, que utiliza as variáveis salvas em bundle para reescreve-las, dessa forma assegurando a permanência quando a tela for reconstruída ou recarregada. 

### Realizando o Cálculo de maior eficiência
Inicialmente o aplicativo ainda não recebia na **MainActivity.kt** os valores escritos nos **EditText** e consequentemente não podia realizar o cálculo
Neste caso, a aplicação possui mais de um **EditText**, fazendo necessário a declaração de um id para cada um, **edGasolina** e **edAlcool**</br>
![image](https://github.com/IsraelCueio/Gas-vs-Alchool-App/assets/68167016/05a41888-3c63-4d15-82c9-1283c8317ddb)</br>
Abaixo podemos ver a inportação para **MainActivity.kt** das variáveis **alcPrice** e **gasPrice** apartir do id presente na declaração dos seus respectivos **EditText** presentes em **activity_main.xml**.
Podemos ver também que o botão é chamada de formar idêntica, declarando uma variável para ele chamada **btCalc**.</br>
![eff26454-2c84-462f-952a-0418b7f7cf9b](https://github.com/IsraelCueio/Gas-vs-Alchool-App/assets/68167016/a15192f6-f14e-4da1-86be-84941a03bbce)</br>
Com as variáveis importadas, podemos realizar o cálculo.</br>
![d6eb6dcb-6253-451f-b071-b2b40745d58f](https://github.com/IsraelCueio/Gas-vs-Alchool-App/assets/68167016/5cd3b31d-887d-4c2a-bc92-2e245eaea590)</br>
A partir da variável criada, **btCalc**, atribuimos um **Listener** que aguarda a interação com o botão para executar o algoritmo que calcula o resultado aguardado pelo usuário.
O objetivo da variável **proportion** é calcular a porcentagem do preço do álcool com relação a gasolina. Com esse valor em mãos, tudo que precisamos fazer é comparar **proportion** a **percentual**. **proportion** deve ser menor que **percentual** para que o álcool seja recomendado.

###Alterações Visuais

![imagem_2024-03-28_124246670](https://github.com/IsraelCueio/Gas-vs-Alchool-App/assets/68167016/9d2cc821-b3cf-47f6-8e35-4770d6754bdc)</br>
A partir de uma prototipação simples no Figma foi escolhida uma nova palheta de cores juntamente a um novo ícone.
![c266b7a6-a65f-4795-a0af-ab9c68bc2da8](https://github.com/IsraelCueio/Gas-vs-Alchool-App/assets/68167016/8aec613f-7707-4ba9-8417-03a9681e9b64)
![7512289c-4cc9-43f3-8834-fc813475fa57](https://github.com/IsraelCueio/Gas-vs-Alchool-App/assets/68167016/78cbb9bf-552a-4700-bddf-594a1f6d2e29)

Na pasta **themes** temos dois arquivos de tema, um para o **lightmode** e outro para o **darkmode**, lá dentro foram alteradas as cores necessárias para alcançar os resultados mostrados acima.
O processo funciona de forma muito intuitiva. 
![imagem_2024-03-28_124611592](https://github.com/IsraelCueio/Gas-vs-Alchool-App/assets/68167016/4c01b46d-2e28-485c-b7c8-e6595ff183fc)</br>
Neste caso, foram alterados os valores de **colorPrimary** e **android:backgroundTint**. Já em **activity_main.xml** referenciamos as cores aos nomes dados às cores nos temas para que assim, o aplicativo possa alternar entre **LightMode** e **DarkMode**.

O ícone foi pego de um banco de ícones gratuíto e acrescentado ao aplicativo a partir da ferramenta nativa do Android Studio.</br>
![image](https://github.com/IsraelCueio/Gas-vs-Alchool-App/assets/68167016/44250814-0c09-4632-8e98-0d49ccc4148f)</br>
Alguns problemas de indentação foram resulvidos apenas alterando a margem e o width de elementos.

##Conclusão
A partir das alterações realizadas neste aplicativo, eu pude ganhar mais familiaridade com o framework e me adaptar um pouco melhor ao IDE do Android Studio.



