public class Cell {

    private static int count = 0;
    private int id;
    private CellItem cellItem;
    private boolean cleared;
    private boolean visited;

    /**
     * Constructor that initializes Cell attributes:
     *     'num': current count
     *     'cellItem': a River with cost -15 or a random Animal
     *     'cleared' and 'visited': false
     */
    public Cell() {
        this.id = count; // assign ID number
        count++; // increment counter

        int randNum = (int) (100 * Math.random());

        if ((randNum % 4) == 0)
            this.cellItem = new CellItem("River", -15);
        else {
            randNum = (int) (4 * Math.random());
            this.cellItem = initAnimal(randNum);
        }

        this.cleared = false;
        this.visited = false;

    }

    /**
     * Creates a random Animal object
     * 
     * @param randNum a random integer 1-4
     * @return an Animal object
     */
    private Animal initAnimal(int randNum) {
        /* TODO: return a new Animal instance using Animal(String, int1, int2) */
            // int2 is the id of the Cell
            // If randNum is 0, String is "Wolf" and int1 is -2
            // If randNum is 1, String is "Boar" and int1 is -1
            // If randNum is 2, String is "Elk" and int1 is 0
            // If randNum is 3 or 4, String is "Hare" and int1 is 1
            String[] animals = { "Wolf", "Boar", "Elk", "Hare", "Hare" };
            int num;
            if(randNum == 4) {
                num = randNum - 3;
            } else {
                num = randNum - 2;
            }
            
            Animal animal = new Animal(animals[randNum], num, this.id);
            return animal;

    }



    /* TODO: Add getter methods: */
        // cellItem getter
        public CellItem getCellItem() {
            return this.cellItem;
        }
        // id getter
        public int getID() {
            return this.id;
        }
        // cleared getter
        public boolean getCleared() {
            return this.cleared;
        }
        // visited getter
        public boolean getVisited() {
            return this.visited;
        }
        // cellCost getter
            // If a cell has been visited, the cellCost getter returns 0
        public int getCellCost() {
            CellItem item = getCellItem();
            int cellCost = item.cost;
            if(getVisited()) {
                cellCost = 0;
            }
            return cellCost;
        }
            
    /* TODO: Add getter methods: */
        // cellItem setter
        public void setCellItem(CellItem cell) {
            this.cellItem = cell;
        }
        // cleared setter
        public void setCleared(boolean cleared) {
            this.cleared = cleared;
        }
        // visited setter
        public void setVisited(boolean visited) {
            this.visited = visited;
        }




    /**
     * Overriding toString() method that returns:
     *     " X " if Cell has been cleared and visited
     *     The first letter the item's name if Cell has been cleared but not visited
     *     A blank string ("   ") if the cell has not been cleared
     * 
     * @return String containing cell's information
     */
    @Override
    public String toString() {
        if (this.cleared) {
            if (this.visited) {

                return " X ";
            } else
                return " " + this.cellItem.toString().charAt(0) + " ";

        } else
            return "   ";

    }

    /**
     * Check if two cells are the same in a grid, based on id.
     * 
     * @param other the other cell to compare to this
     * @return true if same, false otherwise.
     */
    @Override
    /* TODO: declare equals() method */ 
    public boolean equals(Object other) {

        // TODO: return true if cells have the same id
        // Otherwise, return false
        Cell otherCell = (Cell) other;

        return(this.id == otherCell.id);

    }

}
