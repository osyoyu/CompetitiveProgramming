N, K = gets.chomp.split(' ').map(&:to_i)
A = gets.chomp.split(' ').map(&:to_i)

def div_up(a, b)
  a / b + (a % b == 0 ? 0 : 1)
end

min = A.min
pos = 0
rng = 0
moves = 0
loop do
  p A
  break if pos > A.size
  if A[pos] != min
    rng += 1
  else
    m = div_up(rng, (K-1))
    moves += m
    p r = rng % (K-1)
    pos += r
    rng = 0
    [*0..(pos+r)].each {|i| A[i] = min}
  end
  pos += 1

  sleep 1
end

p A
