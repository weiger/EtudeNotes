#begin
Description:
The Shell Game involves three shells/cups/etc upturned on a playing surface, with a ball placed underneath one of them. 
The shells are then rapidly swapped round, and the game involves trying to track the swaps and, once they are complete, 
identifying the shell containing the ball.

This is usually a con, but you can assume this particular game is fair...
Your task is as follows. Given the shell that the ball starts under, and list of swaps, return the location of the ball 
at the end. All shells are indexed by the position they are in at the time.
For example, given the starting position 0 and the swap sequence [(0, 1), (1, 2), (1, 0)]:

The first swap moves the ball from 0 to 1
The second swap moves the ball from 1 to 2
The final swap does not affect the position of the ball.
So
moves = [[0,1], [1,2], [1, 0]]
find_the_ball(0, moves) == 2

#end

def find_the_ball start, moves
  moves.reduce(start) { |ball, (a, b)|
    case ball
    when a then b
    when b then a
    else ball
    end
  }
end

def find_the_ball start, moves
  moves.each{ |move| a,b=move; start = start==b ? a : start==a ? b : start }
  start
end

def find_the_ball start, moves
  moves.reduce(start) { |pos, move|
    pos == move[0] ? move[1] : pos == move[1] ? move[0] : pos
  }
end
