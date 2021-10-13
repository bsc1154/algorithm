        int r1 = query[0]-1;// 테두리 범위 x
        int c1 = query[1]-1;// 테두리 범위 y
        int r2 = query[2]-1;// 테두리 범위 last x
        int c2 = query[3]-1;// 테두리 범위 last y

        int temp = this.matrix[r1][c1]; // 시작위치 값 임시저장
        int min = temp;                 // min값 초기화
        for(int i = r1; i < r2; i++){ // 회전의 1번
            this.matrix[i][c1] = this.matrix[i+1][c1]; //테두리를 한칸씩 이동하여 행렬 초기화
            if(min > this.matrix[i][c1]) min = this.matrix[i][c1];//해당 테두리값중 최소값 구하기
        }
        for(int i = c1; i < c2; i++){ // 회전의 2번
            this.matrix[r2][i] = this.matrix[r2][i+1];
            if(min > this.matrix[r2][i]) min = this.matrix[r2][i];
        }
        for(int i = r2; i > r1; i--){ // 회전의 3번
            this.matrix[i][c2] = this.matrix[i-1][c2];
            if(min > this.matrix[i][c2]) min = this.matrix[i][c2];
        }
        for(int i = c2; i > c1; i--){ // 회전의 4번
            this.matrix[r1][i] = this.matrix[r1][i-1];
            if(min > this.matrix[r1][i]) min = this.matrix[r1][i];
        }
        this.matrix[r1][c1+1] = temp; // 임시저장한 값 저장

        return min; 최솟값 반환
    }
