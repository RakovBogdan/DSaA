package lafore.chapter06.Exercises;

public class Ex6_5TeamCombinations {

    private char[] group;
    private String sequence = "";

    public Ex6_5TeamCombinations(char[] group) {
        this.group = group;
    }

    public void printTeamCombinations(int teamSize) {
        recursiveCombinations(group.length, teamSize, 0);
    }


    private void recursiveCombinations(int groupSize, int teamSize, int groupIndex) {

        if (sequence.length() == 3) {
            System.out.println(sequence);
        }

        if (groupSize == 0 || teamSize == 0 || teamSize > groupSize) {
            return;
        }


        sequence = sequence.concat(Character.toString(group[groupIndex]));
        recursiveCombinations(groupSize - 1, teamSize - 1, groupIndex + 1);


        sequence = sequence.substring(0, sequence.length() - 1);
        recursiveCombinations(groupSize - 1, teamSize, groupIndex + 1);

    }

    public static void main(String[] args) {
        Ex6_5TeamCombinations ex = new Ex6_5TeamCombinations(new char[] {'A', 'B', 'C', 'D', 'E'});
        ex.printTeamCombinations(3);
    }
}
