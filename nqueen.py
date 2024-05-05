n = int(input("Enter N for N-queen problem:"))
ld = [0] * 30
rd = [0] * 30
cl = [0] * 30
def printSolution(board):
    for i in range(n):
        for j in range(n):
            print("Q" if board[i][j] == 1 else ".", end="")
        print()

def solveNQueen(board, col):
    if col>=n:
        return True
    for i in range(n):
        if(ld[i-col+n-1] != 1 and rd[i+col] != 1) and cl[i]!=1:
            board[i][col] = 1
            ld[i-col+n-1] = rd[i+col] = cl[i] = 1
            if solveNQueen(board, col+1):
                return True
            board[i][col] = 0
            ld[i-col+n-1] = rd[i+col] = cl[i] = 0
    return False

def solveNQ():
    board = [[0 for _ in range(n)] for _ in range(n)]
    if not solveNQueen(board, 0):
        print("Solution does not exist!!")
        return False
    printSolution(board)
    return True

if __name__ == "__main__":
    solveNQ()
    
