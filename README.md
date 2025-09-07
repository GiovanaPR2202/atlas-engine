# 🚀 Game Engine (Java + Vulkan + LWJGL)

Uma game engine experimental escrita em **Java**, utilizando **Gradle** para build, **LWJGL** como binding nativo e **Vulkan** como backend gráfico.  
O objetivo é criar um núcleo modular para renderização, assets, ECS e editor de projetos.

---

## 📦 Estrutura inicial do projeto
game-engine/
┣ src/main/java/com/seuprojeto/WindowMain.java # Classe principal (janela GLFW)
┣ build.gradle # Configuração do Gradle + LWJGL
┣ settings.gradle
┗ README.md

yaml
Copiar código

---

## ⚙️ Tecnologias
- [Java 17+](https://adoptium.net/) (JDK 17 ou 21 recomendado)
- [Gradle](https://gradle.org/) para build
- [LWJGL](https://www.lwjgl.org/) (GLFW + Vulkan)
- [Vulkan SDK](https://vulkan.lunarg.com/sdk/home) *(necessário em etapas futuras)*

---

## ▶️ Como rodar
1. Clone o repositório:
   ```bash
   git clone https://github.com/GiovanaPR2202/atlas-engine.git
   cd atlas-engine
   ```
Compile e rode:

bash
Copiar código
./gradlew run
Você deve ver uma janela simples criada via GLFW.

Pressione ESC para fechar.

🗂 Roadmap (curto prazo)
Criar projeto Gradle com LWJGL configurado

Criar janela básica (GLFW + Vulkan ready)

Criar Vulkan Instance + Surface

Renderizar triângulo (Hello Triangle)

Adicionar sistema de logging básico

🤝 Contribuição
Este projeto é pessoal/experimental, mas sugestões são bem-vindas!
Abra uma issue ou PR se quiser contribuir.

📄 Licença
Licença MIT — sinta-se livre para usar, modificar e distribuir.
