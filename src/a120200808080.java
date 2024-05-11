import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class a120200808080 {
    private static final int MEMORY_SIZE = 256;
    private static int[] memory = new int[MEMORY_SIZE];
    private static int accumulator = 0;
    private static int flagF = 0;
    private static int pc = 0;
    private static int lineCount=0;
    private static String[] lines = new String[0]; 


    public static String[] readLinesFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return lines.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            System.out.println("Önder POLATDEMİR");
            System.out.println("Please use command-line like: java a120200808080 program.txt");
            return;
        }

        String fileName = args[0];
        lines = readLinesFromFile(fileName);

        executeLoop(lines, pc);
    }

    private static void executeInstruction(String instructionLine) throws IOException {
        String[] part = instructionLine.split("\\s+");
        String operation = part[1];
        int operand = part.length >= 3 ? Integer.parseInt(part[2]) : 0;

        switch (operation) {
            case "START":
                break;
            case "LOAD":
                accumulator = operand;
                System.out.println("Accumulator after LOAD: " + accumulator);
                break;
            case "STORE":
                memory[operand] = accumulator;
                System.out.println("Memory at " + operand + ": " + memory[operand]);
                break;
            case "LOADM":
                accumulator = memory[operand];
                System.out.println("Accumulator after LOADM: " + accumulator);
                break;
            case "ADDM":
                accumulator += memory[operand];
                System.out.println("Accumulator after ADDM: " + accumulator);
                break;
            case "ADD":
                accumulator += operand;
                System.out.println("Accumulator after ADD: " + accumulator);
                break;
            case "CMPM":
                if (accumulator < memory[operand]) {
                    flagF = -1;
                } else if (accumulator > memory[operand]) {
                    flagF = 1;
                } else {
                    flagF = 0;
                }
                System.out.println("F flag after CMPM:" + flagF);
                break;
            case "CJMP":
                if (flagF > 0) {
                    executeLoop(lines, operand);
                }
                System.out.println("Accumulator after CJMP: " + accumulator);
                break;
            case "JMP":
                pc = operand;
                executeLoop(lines, operand);
                break;
            case "DISP":
                System.out.println("Accumulator after all program executed: " + accumulator);
                break;
            case "HALT":
                System.out.println("Program halted.");
                System.exit(0);
                break;
            default:
                System.out.println("Unknown instruction: " + operation);
                break;
        }
        pc++;
    }

    
    private static void executeLoop(String[] linesList, int pc) throws IOException {
        System.out.println();
        for(int i = pc; i< lineCount; i++){
            executeInstruction(linesList[i]);
        }
    }
}
