package logic;

public class Room{
	private Tile[][] tiles;
	
	public Room(int size) {
		tiles = new Tile[size][size];
		
	}
	
	public boolean addTile(Tile tile) {
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {
				if(tiles[i][j] == null) {
					setTile(tile, i, j);
					return true;
				}
			}
		}
		return false;
	}
	
	public void setTile(Tile tile, int x, int y) {
		tiles[x][y] = tile;
	}
	
	public Tile getTile(int x, int y) throws NullPointerException{
		return tiles[x][y];
	}

}
