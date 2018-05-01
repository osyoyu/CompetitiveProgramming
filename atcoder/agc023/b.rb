def symmetrical?(board)
  board.size.times do |i|
    i.upto(board.size - 1) do |j|
      return false if (board[i][j] != board[j][i])
    end
  end

  true
end

N = gets.to_i
board = []
N.times do |i|
  board.push(gets.chomp.split(''))
end

answer = 0;
N.times do |i|
  N.times do |j|
    board2 = board.map {|l| l.rotate(i) }.transpose.map{|l| l.rotate(j) }
    answer += 1 if (symmetrical?(board2))
  end
end
puts answer
