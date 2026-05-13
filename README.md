# AGENTS.md - AI Coding Guide for Projetos JAVA

## Project Overview
Two independent Java projects in student learning context:

1. **games/** - Text-based RPG with battles, quests, and character progression
2. **maquinaDecartao/** - Banking/credit card system (partial implementation)

Both use console-based UI with Scene-pattern state management. No external frameworks (pure Java + java.time, java.util).

---

## Architecture Patterns

### Game Loop Architecture (games/)
- **Entry Point**: `Game.main()` - infinite loop with top-level menu (case 1-5)
- **Navigation Pattern**: Each class instantiates others (`PainelJogo` → `Cidade`, `Floresta`, `SalaPVP`)
- **Scene Management**: Menu parameters (1-8) route to different displays via `Game.painel(int)`
- **State Container**: `Jogador` holds all character state; battles mutate object state, then call reset methods (`acabaouBatalha()`, `endPVP()`)

**Key Flow** (for extending gameplay):
```
Game.main() loop
  ├─ case 1: Create Jogador → add to jogadoresTotal ArrayList
  ├─ case 2: SalaPVP.batalhaPVP() → mutates HP/money, calls venceubatalha()
  ├─ case 4: PainelJogo.painelJogador() → nested menus for Cidade/Floresta
  │   ├─ Cidade.menuLoja() → purchase items via Jogador.fezCompra()
  │   └─ Floresta.campoDeTreino() / cacarMonstros() → battles reset on completion
```

### Item & Inventory System
- **Item Coding**: Three types (22=Cura, 33=Dano, 44=Espada) hardcoded across `Jogador`, `Floresta`, `SalaPVP`
- **Inventory**: `ArrayList<String> inventario` in Jogador tracks items by name
- **Equipment**: `itemEquipado` field manages active bonuses (44 grants 1.5x ATK)
- **Issue**: `usouItem()` returns int codes (0=success, 1=invalid, 2=missing) - extend for new items

### Battle System (PVP & Monster Hunting)
- **PVP** (`SalaPVP.batalhaPVP`): Alternating turns, attacker/defender role swap, random first-player selection
- **Defense Mechanic**: 1/3 probability vs monsters (hardcoded in `sorteioStatusDefesa` logic), randomized vs PVP
- **Monster Hunt** (`Floresta.cacarMonstros`): Turn limit (finalTurno < 3) before monster's turn, defense success varies by monster type
- **Rewards**: XP added via `ganhouExp()` > triggers automatic ranking up if `exp >= expParaUpar`

### Progression System (Ranking/Leveling)
- **Ranking Array**: `char rankings[] = {'F','E','D','C','B','A','S'}`
- **Exponential Scaling**: 
  - `expParaUpar *= 1.5` 
  - `hp *= 1.5`, `atk *= 1.5` on rank-up
  - **Bug**: Equipment bonus re-applies on rank-up (`equipouItem()` called in `seterAumentarRancking()`)

### Banking System (maquinaDecartao/)
- **Account Model**: `Conta` holds saldo, titular, senhaHash; `Cartao` (static ArrayList) attached per account
- **Hash Function**: Custom algorithm (XOR + bitshift spread) in both `Conta` and `Cartao` - **duplicated code**
- **Transaction History**: `historicoConta` objects added to static `Conta.historico`; `Parcelamento` objects track installments
- **Unfinished**: `Banco.main()` is stubbed (line 10-12)

---

## Developer Workflows & Commands

### Compilation & Execution
```powershell
# Navigate to project root (contains .iml file)
cd "C:\SpaceWork\PASTA-PC-JOEL\Projetos JAVA"

# Compile all Java files
javac games/*.java
javac maquinaDecartao/*.java

# Run games (requires text input)
java games.Game

# Run banking system (stub - no main logic)
java maquinaDecartao.Banco

# Run utilities
java games.Controle        # Input validation demo
java maquinaDecartao.teste # Date formatting demo
```

### IntelliJ Integration
- Project uses `.iml` file (no Maven/Gradle)
- Classes run via main() methods; no test framework
- Console I/O heavy - requires manual testing

---

## Critical Patterns & Conventions

### UI Menu System
Each screen is a `painel(int)` call with hardcoded printf strings:
```java
// In Game.java
if (valor == 1) { /* Main menu: ops 1-5 */ }
else if (valor == 2) { /* Class selection */ }
else if (valor == 3) { /* Battle actions 1-4 */ }
// Pattern: valor parameter routes to different screens
```
**Convention**: All UI in single method; extend by adding new `valor` cases.

### Input Pattern (Text-Based)
Standard `Scanner` usage with `nextInt()` + `nextLine()` (to consume newline):
```java
Scanner sc = new Scanner(System.in);
System.out.printf("Digite sua opcao: ");
int op = sc.nextInt();
sc.nextLine(); // Consume newline - REQUIRED before nextLine()
```
**Gotcha**: `Controle` class provides validated input methods; use when robustness matters.

### Static State Issues
- `Cartao.cores` is static & mutated during card creation (removes chosen color)
- `Cartao.totParcelamentos` and `Conta.historico` are static (shared across all instances)
- **Fix needed**: Move to instance fields or use proper persistence layer

### Portuguese Naming & Comments
- Entire codebase in Portuguese (method names, variable names, system messages)
- Comments like `"// Joel Burro"` (developer's humor) scattered throughout
- **Important**: Maintain consistency when extending; Portuguese is the project language

### Animation System (Floresta)
- ASCII art hard-coded in `animacaoBoneco(int valor, char letraTargada)`
- Minigame in `campoDeTreino()` reads raw `System.in` bytes for key detection (no Scanner)
- Timing: `Thread.sleep(1000)` for 1-second delays between animations
- **Pattern**: Value parameter (1-10) selects different ASCII art + animation state

### Error Handling
- No try-catch for expected errors (invalid input defaults to "digit a number from X to Y")
- Resource leaks possible (Scanners never closed)
- `System.err.println()` used non-standardly for output (should be System.out)

---

## Extension Points & Common Tasks

### Add New Item Type
1. Choose new code (45+) to avoid collisions
2. Add to `usouItem()` switch in `Jogador`
3. Add to inventory display in `mostrarInventario()` / `inventarioModiicavel()`
4. Add to battle item usage in `SalaPVP` + `Floresta.cacarMonstros()`
5. Add to shop in `Cidade.menuLoja()`

### Add New Character Class
1. Add branch to `Jogador` constructor (match existing HP/ATK/EXP pattern)
2. Update `Game.painel(2)` display text
3. Test with `Game.main()` case 1 (create new character)

### Add New Monster Type
1. Add branch to `Monstro` constructor (set vida/atk/expSeDerrotado/moneySeDerrotado)
2. Update `Floresta.cacarMonstros()` tipoMonstros[] array
3. Update `animacaoBoneco()` indices if new monster needs unique animation

### Complete Banking System
1. Implement `Banco.main()` with menu for account creation/access
2. Refactor duplicate hash function → util method
3. Move static collections to instance fields
4. Add persistence (file I/O) for `Conta`/`Cartao` objects

---

## Key Files Reference

| File | Purpose | Lines | Key Methods |
|------|---------|-------|-------------|
| `Game.java` | Main menu loop, player registry | 196 | `main()`, `painel(int)` |
| `Jogador.java` | Character state & mechanics | 249 | `venceubatalha()`, `usouItem()`, `seterAumentarRancking()` |
| `SalaPVP.java` | PVP battle engine | 135 | `batalhaPVP(Jogador, Jogador)` |
| `Floresta.java` | Minigame + monster hunting | 326 | `campoDeTreino()`, `cacarMonstros()`, `animacaoBoneco()` |
| `Conta.java` | Bank account & auth | 95 | `algortmoHash()`, `setSaldo(double, int)` |
| `Cartao.java` | Credit card & purchases | 142 | `fezCompra()`, `fezCompraParcelado()`, `criadorDeCodigo()` |

---

## Testing Notes
- No automated tests (manual instruction-input testing only)
- Reproducible bug: Equip item 44 (Espada), rank up → ATK bonus applied twice
- Scanner resource cleanup never called (no `.close()`)

