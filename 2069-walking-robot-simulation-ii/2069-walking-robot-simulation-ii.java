class Robot {
    private int width;
    private int height;
    private int perimeter;
    private int pos;
    private boolean moved;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width - 1) + 2 * (height - 1);
        this.pos = 0;
        this.moved = false;
    }
    
    public void step(int num) {
        pos = (pos + num) % perimeter;
        moved = true;
    }
    
    public int[] getPos() {
        if (pos <= width - 1) {
            return new int[]{pos, 0};
        } else if (pos <= width + height - 2) {
            return new int[]{width - 1, pos - (width - 1)};
        } else if (pos <= 2 * width + height - 3) {
            return new int[]{2 * width + height - 3 - pos, height - 1};
        } else {
            return new int[]{0, perimeter - pos};
        }
    }
    
    public String getDir() {
        if (pos == 0) {
            return moved ? "South" : "East";
        } else if (pos <= width - 1) {
            return "East";
        } else if (pos <= width + height - 2) {
            return "North";
        } else if (pos <= 2 * width + height - 3) {
            return "West";
        } else {
            return "South";
        }
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */