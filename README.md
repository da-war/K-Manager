Here’s the complete README content in Markdown syntax, formatted properly for your file:

```markdown
# Kotlin Application

## Description
This is a simple Kotlin application that demonstrates how to write, compile, and run Kotlin code in the terminal.

## Prerequisites
- **Java JDK** (version 11 or later)
- **Kotlin** (installed via [SDKMAN!](https://sdkman.io/) or downloaded from the [official Kotlin website](https://kotlinlang.org/docs/command-line.html))

## Installation

### Step 1: Install Java JDK
1. Download and install the Java JDK from the [Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use a package manager like `apt` or `brew`.

### Step 2: Install Kotlin
#### Using SDKMAN!
1. Open your terminal and run the following command to install SDKMAN!:
   ```bash
   curl -s "https://get.sdkman.io" | bash
   ```
2. After installation, run the following command to initialize SDKMAN!:
   ```bash
   source "$HOME/.sdkman/bin/sdkman-init.sh"
   ```
3. Install Kotlin using SDKMAN!:
   ```bash
   sdk install kotlin
   ```

#### Manual Installation
1. Download the Kotlin compiler from the [Kotlin Releases page](https://kotlinlang.org/releases.html).
2. Follow the installation instructions based on your operating system.

## Running the Application

### Step 1: Open Terminal
Navigate to the directory where your Kotlin application is located.

### Step 2: Compile the Kotlin File
Compile your Kotlin file (e.g., `Main.kt`) using the following command:
```bash
kotlinc Main.kt -include-runtime -d Main.jar
```

### Step 3: Run the Compiled Application
Run the compiled JAR file using the following command:
```bash
java -jar Main.jar
```

## Example Output
When you run the application, you should see the following output:
```
Hello, Kotlin in VS Code with Zsh!
```

## Additional Notes
- Ensure you replace `Main.kt` with the actual name of your Kotlin file if it's different.
- If you make any changes to your Kotlin code, remember to recompile it before running it again.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

You can use this Markdown code directly in your `README.md` file.
